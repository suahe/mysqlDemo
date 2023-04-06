package com.example.demo.bean;

import java.util.List;

/**
 * @ClassName: ControlBatchDto
 * @Author: cqt123456789
 * @CreateTime: 2022/1/20 17:17
 * @Description:
 */
public class ControlBatchDto {

    private List<User> controlResInfoList;

    public ControlBatchDto() {

    }

    public ControlBatchDto(List<User> controlResInfoList) {
        this.controlResInfoList = controlResInfoList;
    }

    public List<User> getControlResInfoList() {
        return controlResInfoList;
    }

    public void setControlResInfoList(List<User> controlResInfoList) {
        this.controlResInfoList = controlResInfoList;
    }
}
