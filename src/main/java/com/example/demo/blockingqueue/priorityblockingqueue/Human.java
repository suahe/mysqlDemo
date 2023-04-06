package com.example.demo.blockingqueue.priorityblockingqueue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: Human
 * @Author: cqt123456789
 * @CreateTime: 2022/1/10 15:59
 * @Description:
 */
@Data
@AllArgsConstructor
public class Human {

    private int maney;
    private String name;

    @Override
    public String toString() {
        return getName() + "[存款:"+getManey()+"]";
    }
}
