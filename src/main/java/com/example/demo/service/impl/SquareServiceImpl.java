package com.example.demo.service.impl;

import com.example.demo.service.ShapeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SquareServiceImpl
 * @Author: cqt123456789
 * @CreateTime: 2022/5/31 10:22
 * @Description:
 */
@Service
public class SquareServiceImpl implements ShapeService {

    @Override
    public String gameType() {
        return "test2";
    }

    @Override
    public String draw(String type) {
        return "Square:"+type;
    }
}