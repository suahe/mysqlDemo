package com.example.demo.blockingqueue.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName: TestMain
 * @Author: cqt123456789
 * @CreateTime: 2022/1/10 16:03
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Human> queue = new PriorityBlockingQueue<>(200, new HumanComparator());
        Thread thread = new Thread(new ProducerRunnable(queue));
        thread.start();
        thread.join();
        new Thread(new ConsumerRunnable(queue)).start();
    }

}
