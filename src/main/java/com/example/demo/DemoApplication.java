package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.BookBean;
import com.example.demo.bean.CreatePushResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencent.xinge.*;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@SpringBootApplication
@EnableCaching
public class DemoApplication {

    @Value("${book.author}")
    private String bookVlaue;
    @Value("${book.name}")
    private String nameValue;
    @Autowired
    private BookBean bookBean;
    public static ConfigurableApplicationContext context;
    public static String[] args;

    public static void main(String[] args) {
        DemoApplication.args = args;
        DemoApplication.context = SpringApplication.run(DemoApplication.class, args);
    }


    @RequestMapping("/")
    public String index() {
        System.out.println(XingeApp.pushTokenIos(2200333624L, "36d26eae11c8dc51612c1a151c635d8d", "测试", "ddb190e7e2829706d21cd909ce0ebbae046e71ecbe70b231048ab5a3fd33a77e", XingeApp.IOSENV_DEV));
        return "book is name "+nameValue+" and book author is:"+bookVlaue;
    }

    @RequestMapping("/index")
    public String indexBook() {
        System.out.println(XingeApp.pushTokenAndroid(2100333662L,"cf7fe56b8d39d742d8ab1a4455c278eb","这是一个标题","测测测试","ca32dc282a48a40f45b2bd42b49ccbbe44864654").toString());

        return "book is name: "+bookBean.getName()+" and book author is:"+bookBean.getAuthor();
    }

    @RequestMapping("/sendMesage")
    public String sendMessage() {
        XingeApp xingeApp = new XingeApp(2100333662L,"cf7fe56b8d39d742d8ab1a4455c278eb");
        Message message = new Message();
        message.setTitle("这是是是好事");
        message.setContent("是的男生军方考试考了购房人内蒙古");
        message.setType(Message.TYPE_NOTIFICATION);
        message.setExpireTime(0);
        JSONObject ret = xingeApp.pushSingleDevice("ca32dc282a48a40f45b2bd42b49ccbbe44864654", message);
        System.out.println(ret.toString());
        return "ok";
    }

    @RequestMapping("/account")
    public String account() {
        XingeApp xingeApp = new XingeApp(2100333662L,"cf7fe56b8d39d742d8ab1a4455c278eb");
        Message message = new Message();
        message.setExpireTime(0);
        message.setTitle("下发多个");
        message.setContent("下发多个安卓测试");
        message.setType(Message.TYPE_NOTIFICATION);
        List<String> accountList = new ArrayList<String>();
        accountList.add("010537d4b30e478cbb6eb6a12b26bbff");
        accountList.add("01983146314d4455989f0480e284f15c");
        JSONObject ret = xingeApp.pushAccountList(0, accountList, message);
        return ret.toString();
    }

    @RequestMapping("/message")
    public String messgae() {
        XingeApp xingeApp = new XingeApp(2100333662L,"cf7fe56b8d39d742d8ab1a4455c278eb");
        Message message1 = new Message();
        message1.setType(Message.TYPE_NOTIFICATION);
        Map<String, Object> custom = new HashMap<String, Object>();
        custom.put("key1", "1");
        message1.setTitle("测试cdvfamessage");
        message1.setContent("大vdsf小");
        message1.setCustom(custom);
        List<String> accountList = new ArrayList<String>();
        accountList.add("010537d4b30e478cbb6eb6a12b26bbff");
        JSONObject ret = xingeApp.pushAccountList(0, accountList, message1);
        return ret.toString();
    }

    @RequestMapping("/pushAccountListMultiple")
    public String pushAccountListMultiple () {
        Message message1 = new Message();
        message1.setType(Message.TYPE_NOTIFICATION);
        Map<String, Object> custom = new HashMap<String, Object>();
        custom.put("key1", "1");
        message1.setTitle("简直了");
        message1.setContent("你好过分啊");
        message1.setCustom(custom);
        XingeApp push = new XingeApp(2100333662L,"cf7fe56b8d39d742d8ab1a4455c278eb");
        JSONObject ret = push.createMultipush (message1);
        System.out.println(ret.toString());
        int ret_code = ret.getInt("ret_code");
        CreatePushResult pushResult = null;
        if(ret_code==0) {
            pushResult = JSON.parseObject(ret.toString(),CreatePushResult.class);
            List<String> accountList = new ArrayList<String>();
//            accountList.add("010537d4b30e478cbb6eb6a12b26bbff");
            accountList.add("01983146314d4455989f0480e284f15c");
            accountList.add("03f5c4d3f0584ad398982ab76f4a38df");
            JSONObject ret1 = push.pushAccountListMultiple (pushResult.getResult().getPush_id(), accountList);
            return ret1.toString();
        }
        return ret.toString();
    }

}

