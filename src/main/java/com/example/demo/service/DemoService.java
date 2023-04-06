package com.example.demo.service;

import com.example.demo.bean.Person;
import com.sun.javafx.image.PixelUtils;

public interface DemoService {
    public Person savePersonWithRollBack(Person person);
    public Person savePersonWithoutRollBack(Person person);

    //以下是测试cache缓存
    public Person save(Person person);
    public void remove(Long id);
    public Person findOne(Person person);
}
