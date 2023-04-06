package com.example.demo.service;

import com.example.demo.bean.Person;
import com.example.demo.dao.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author zcx
 * @Title 测试事务回滚服务实现
 * @date 2019年01月05日 20:55
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    public PersonRepository repository;

    @Override
    @Transactional(rollbackFor={IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = repository.save(person);
        if(p.getName().equals("zcx")) {
            throw new IllegalArgumentException("zcx已存在，数据将回滚");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor={IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = repository.save(person);
        if(p.getName().equals("zcx")) {
            throw new IllegalArgumentException("zcx虽已存在，但数据将不回滚");
        }
        return p;
    }

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p = repository.save(person);
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value ="people")
    public void remove(Long id) {
        System.out.println("删除了id、key为："+id+"的数据缓存");
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        org.springframework.data.domain.Example<Person> personExample = org.springframework.data.domain.Example.of(person);
        Person p = repository.findOne(personExample).orElse(null);
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }

    public static void main(String[] args) throws JsonProcessingException {

        //集合一
        List _first=new ArrayList();
        _first.add("a");
        _first.add("b");
        _first.add("c");
        _first.add("d");
        _first.add("d");
        _first.add("c");
        //集合二
        List _second=new ArrayList();
        _second.add("c");
        _second.add("b");
        _first.removeAll(_second);
        System.out.println("剩余"+_first);
    }

}

class ImpItem {
    private String time;
    private String flag;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
