package com.example.demo.factory;

import com.example.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ShapeFactory
 * @Author: cqt123456789
 * @CreateTime: 2022/5/31 10:22
 * @Description:
 */
@Service
public class ShapeFactory {

    /**
     * 	初始化时可以自动将ShapeService加入到List中，
     *  key为实现ShapeService类shapeService.gameType()指定的值
     *  value为实现ShapeService类
     *  Map<shapeService.gameType(),ShapeService>
     */
    private Map<String, ShapeService> map = new ConcurrentHashMap<String, ShapeService>();

    public ShapeFactory(List<ShapeService> serviceList) {
        for (ShapeService shapeService : serviceList) {
            map.put(shapeService.gameType(),shapeService);
        }
    }

    public ShapeService geTestInterface(String key) {
        System.out.println(key);
        return map.get(key);
    }

}