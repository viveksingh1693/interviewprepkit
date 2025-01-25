package com.viv.behavioraldesignpatterns.command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MailTaskRunner implements Runnable {

    private Thread runner;
    private BlockingQueue<Command> pendingCommands;
    private volatile boolean stop;

    private static final MailTaskRunner RUNNER = new MailTaskRunner();

    public static MailTaskRunner getInstance() {
        return RUNNER;
    }

    private MailTaskRunner() {
        pendingCommands = new LinkedBlockingQueue<>();
        runner = new Thread(this);
        runner.start();
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Command cmd = pendingCommands.take();
                cmd.execute();
            } catch (InterruptedException e) {
                if (stop) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void addCommand(Command cmd) {
        pendingCommands.offer(cmd);
    }

    public void stop() {
        stop = true;
        runner.interrupt();
    }
}
