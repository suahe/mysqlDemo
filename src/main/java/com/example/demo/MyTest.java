package com.example.demo;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @ClassName: MyTest
 * @Author: cqt123456789
 * @CreateTime: 2022/6/27 14:01
 * @Description:
 */
public class MyTest{

    public static void main(String[] args) throws Exception {
        String key = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKV9oPKXNybH9Q6sh9uBk6uvoB70TF0jOVz9KltqCmvD9D11w4ab+mS1oYCrkOURM/VZoxruCpj3vTNYNqOvUTsCAwEAAQ==";
        String password = "eszGeWVGKyfM5C7j6fchdvyzlBAVADMhzqEdINHskN0VZVCBrW2YVykzqKsqz2AGJOLx+kz5X02agTptcXaJtg==";
        password = ConfigTools.decrypt(key,password);
        System.out.println(password);
    }

}
