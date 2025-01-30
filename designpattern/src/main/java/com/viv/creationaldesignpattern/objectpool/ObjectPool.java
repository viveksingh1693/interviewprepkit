package com.viv.creationaldesignpattern.objectpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

public class ObjectPool<T extends Poolable> {
    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int count) {
        availablePool = new LinkedBlockingDeque<>();
        for (int i = 0; i < count; i++) {
            availablePool.add(creator.get());
        }
    }

    public T get() {
        T instance = null;
        try {
            instance = availablePool.take();
        } catch (InterruptedException e) {
            System.out.println("take() was interrupted");
        }
        return instance;
    }

    public void release(T instance) {
        instance.reset();
        try {
            availablePool.put(instance);
        } catch (InterruptedException e) {
            System.out.println("put() was interrupted");
        }
    }
}
