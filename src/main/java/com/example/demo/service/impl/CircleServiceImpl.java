package com.example.demo.service.impl;

import com.example.demo.service.ShapeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CircleServiceImpl
 * @Author: cqt123456789
 * @CreateTime: 2022/5/31 10:20
 * @Description:
 */
@Service
public class CircleServiceImpl implements ShapeService {
    @Override
    public String gameType() {
        return "test1";
    }

    @Override
    public String draw(String type) {
        return "Circle:"+type;
    }
}