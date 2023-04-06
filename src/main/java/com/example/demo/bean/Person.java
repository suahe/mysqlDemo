package com.example.demo.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author zcx
 * @Title 人类的信息
 * @date 2019年01月02日 19:50
 **/
@Entity //1
@Data
public class Person {

    @Id //2
    @GeneratedValue //3
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
        super();
    }
    public Person(Long id, String name, Integer age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
