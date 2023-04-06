package com.example.demo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author zcx
 * @Title 用户信息类
 * @date 2019年01月06日 15:51
 **/
@Document //1
@Data
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
    @Field("locs")
    private Collection<Location> locations =  new LinkedHashSet<Location>();

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String id) {
        this.id = id;
    }
}
