package com.example.demo.service.impl;

import com.example.demo.service.ShapeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RectangleServiceImpl
 * @Author: cqt123456789
 * @CreateTime: 2022/5/31 10:21
 * @Description:
 */
@Service
public class RectangleServiceImpl implements ShapeService {
    @Override
    public String gameType() {
        return "test3";
    }

    @Override
    public String draw(String type) {
        return "Rectangle:"+type;
    }
}