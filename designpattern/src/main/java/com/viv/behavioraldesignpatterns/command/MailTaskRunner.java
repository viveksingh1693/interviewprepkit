package com.viv.behavioraldesignpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class MailTaskRunner implements Runnable {
    
    private Thread runner;

    private List<Command> pendingCommands;

    private volatile boolean stop;

    private static final MailTaskRunner RUNNER = new MailTaskRunner();

    public static final MailTaskRunner getInstance() {
        return RUNNER;
    }

    private MailTaskRunner() {
        pendingCommands = new ArrayList<>();
        runner = new Thread(this);
        runner.start();
    }

    @Override
    public void run() {
        while(true){
            Command cmd = null;

            synchronized (pendingCommands) {
                if(pendingCommands.isEmpty()){
                    try {
                        pendingCommands.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    cmd = pendingCommands.remove(0);
                }
            }

            if (cmd == null) {
                return;
            }
            cmd.execute();
        }
    }

    public void addCommand(Command cmd){
        synchronized (pendingCommands) {
            pendingCommands.add(cmd);
            pendingCommands.notifyAll();
        }
    }

    public void stop(){
        stop = true;
        runner.interrupt();
    }
}
