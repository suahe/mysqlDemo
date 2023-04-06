package com.example.demo.controller;

import com.example.demo.bean.MailSenderInfo;
import com.example.demo.bean.Person;
import com.example.demo.dao.PersonRepository;
import com.example.demo.service.DemoService;
import com.example.demo.service.EmailUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author zcx
 * @Title Spring Data Jpa 数据库访问控制器测试
 * @date 2019年01月04日 16:10
 **/
@RestController
public class DataController {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private DemoService demoService;

    @Autowired
    private EmailUtils emailUtils;

    @RequestMapping("/name/{name}")
    public List<Person> findByName(@PathVariable("name") String name) {
        List<Person> people = repository.findByName(name);
        return people;
    }

    @RequestMapping("/updateName/{name}")
    public int setName(@PathVariable("name") String name) {
        int people = repository.setName(name,Long.parseLong("1"));
        return people;
    }

    @RequestMapping("/insert")
    public void insert() {
        Person person = new Person();
        person.setId(Long.parseLong("5"));
        person.setAge(16);
        person.setName("zcx3");
        person.setAddress("福州");
        repository.save(person);
    }

    @RequestMapping("/delete")
    public void delete() {
        repository.deleteById(Long.parseLong("4"));
    }

    /**
    * 排序
    * @author zcx
    * @param
    * @return
    * @date        2019/1/4 19:08
    */
    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = repository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    /**
    * 测试排序
    * @author zcx
    * @param
    * @return
    * @date        2019/1/4 19:10
    */
    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> personPage = repository.findAll(PageRequest.of(0,3,new Sort(Sort.Direction.ASC,"age")));
        return personPage;
    }

    /**
    * 测试数据回滚
    * @author zcx
    * @param
    * @return
    * @date        2019/1/5 21:47
    */
    @RequestMapping("/rollback")
    public Person rollback() {
        Person person = new Person();
        person.setName("zcx");
        person.setAge(23);
        return demoService.savePersonWithRollBack(person);
    }

    /**
    * 测试数据不会滚
    * @author zcx
    * @param
    * @return
    * @date        2019/1/5 21:48
    */
    @RequestMapping("/noRollback")
    public Person noRollback() {
        Person person = new Person();
        person.setName("zcx");
        person.setAge(23);
        return demoService.savePersonWithoutRollBack(person);
    }

    @RequestMapping(value = "/put")
    public Person put() {
        Person person = new Person();
        person.setName("cc");
        person.setAge(23);
        person.setAddress("成都");
        return demoService.save(person);
    }

    @RequestMapping(value = "/cacheAble")
    public Person cacheAble() {
        Person person = new Person();
        person.setId(Long.parseLong("2"));
        return demoService.findOne(person);
    }

    @RequestMapping(value = "/evit")
    public String evit() {
        demoService.remove(Long.parseLong("2"));
        return "ok";
    }


    @RequestMapping(value = "/send")
    public String sendEmail() {
        String email = "1763859536@qq.com";
        MailSenderInfo mailInfo = new MailSenderInfo();
        //设置服务地址
        mailInfo.setMailServerHost("smtp.qiye.163.com");
        //设置服务端口
        mailInfo.setMailServerPort("465");
        mailInfo.setValidate(true);
        //设置发送人名字
        mailInfo.setUserName("ywgj@linkcircle.cn");
        mailInfo.setPassword("cqt@01086469999");
        //设置发送人地址
        mailInfo.setFromAddress("ywgj@linkcircle.cn");
        //设置接收人地址
        String[] toAdd = {email};
        mailInfo.setToAddress(toAdd);
        mailInfo.setSubject("推送消息失败通知");
        // 设置邮件内容
        mailInfo.setContent("这是一个测试");
        emailUtils.sendTextMail(mailInfo);
        return "ok";
    }
}
