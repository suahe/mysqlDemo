package com.example.demo;

import com.example.demo.bean.ControlBatchDto;
import com.example.demo.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: test
 * @Author: cqt123456789
 * @CreateTime: 2022/1/20 16:49
 * @Description:
 */
public class test {

    public static void main(String[] args) {

        List<User> controlResList = new ArrayList<>();

        for (int j = 0;j<2;j++) {
            ControlBatchDto controlBatchDto = saveResInfo(j,null);
            controlResList.addAll(controlBatchDto.getControlResInfoList());
        }
        System.out.println(controlResList);
    }

    private static ControlBatchDto saveResInfo(int pumpId, List<User> doControlResList) {
        List<User> controlResList = new ArrayList<>();
        for (int i = 0;i<6;i++) {
            User user = new User("第"+i+"遍"+","+pumpId);
            controlResList.add(user);
        }
        ControlBatchDto controlBatchDto = new ControlBatchDto();
        controlBatchDto.setControlResInfoList(controlResList);
        return controlBatchDto;
    }
}
