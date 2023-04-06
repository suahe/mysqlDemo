package com.example.demo.blockingqueue.priorityblockingqueue;

import java.util.Comparator;

/**
 * @ClassName: HumanComparator
 * @Author: cqt123456789
 * @CreateTime: 2022/1/10 15:59
 * @Description:
 */
public class HumanComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o2.getManey() - o1.getManey();
    }
}
