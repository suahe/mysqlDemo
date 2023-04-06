package com.example.demo.blockingqueue.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName: ConsumerRunnable
 * @Author: cqt123456789
 * @CreateTime: 2022/1/10 16:02
 * @Description:
 */
public class ConsumerRunnable implements Runnable{

    private PriorityBlockingQueue<Human> queue;

    public ConsumerRunnable(PriorityBlockingQueue<Human> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            Human take = queue.poll();
            if (take == null){
                break;
            }
            System.out.println(take + " 办理业务.");
        }
    }
}
