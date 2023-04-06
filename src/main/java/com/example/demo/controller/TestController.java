package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.factory.ShapeFactory;
import com.example.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @ClassName: TestController
 * @Author: cqt123456789
 * @CreateTime: 2022/5/31 10:26
 * @Description:
 */
@RestController(value = "/")
public class TestController {
    @Autowired
    private ShapeFactory shapeFactory;

    @RequestMapping(value = "msg/{key}",method = RequestMethod.GET)
    public String getMsg(@PathVariable("key")String key) {
        ShapeService test = shapeFactory.geTestInterface(key);
        return test.draw("test test");
    }

    @RequestMapping(value = "/restart",method = RequestMethod.GET)
    public void restart() {
        DemoApplication.context.close();
        DemoApplication.context = SpringApplication.run(DemoApplication.class,
                DemoApplication.args);

    }

    @RequestMapping(value = "/mysql/password", method = RequestMethod.GET, produces = "application/json")
    public void test() {
        //jar包地址
        String jarPath="E:\\HbMavenLocalWarehouse\\com\\linkcircle\\lk-ss\\1.3\\lk-ss-1.3.jar";
        try {
            //获取生成的URL地址
            URL url1 = new URL("file:"+jarPath);
            //获取类加载器
            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[]{url1}, Thread.currentThread()
                    .getContextClassLoader());
            //获取对应的类
            Class<?> myClass1 = myClassLoader1.loadClass("com.linkcircle.ss.LHikariDataSource");
            //获取实例
            Object action1 = myClass1.newInstance();
            System.out.println(action1);
            //获取方法，下面的decryptPassword对应着下图方法，将密码传参进去
            Method method=myClass1.getDeclaredMethod("decryptPassword",String.class);
            method.setAccessible(true);
            //将实例传入，执行方法
            method.invoke(action1,"Be5N7kcJV4UqfrRX2k74Pb5wfdRUjcxb6BquYn4SdzxzwFO4oLqKIOeb3zHiQv+PdjhkxKmPatYibT7ab46PHA==");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }
    }
}