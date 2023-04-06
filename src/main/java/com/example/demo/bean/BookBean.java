package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 不用get,set是因为引入了lombok,
 * @author zcx
 * @Title 书籍配置
 * @date 2018年12月29日 16:39
 **/
@Component
@ConfigurationProperties(prefix = "book")
@Data
public class BookBean {
    private String author;
    private String name;
}
