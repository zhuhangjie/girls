package com.zhuhangjie.girl.controller;

import com.zhuhangjie.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RestController注解为spring4.0后的功能，其功能代表Controller注解+ResponseBody注解，返回json
 * 如果用Conroller注解的话必须要配合模板使用
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    /*@Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

    //为了安全最好使用method的方法
    //@RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    //组合注解更加省力
    @GetMapping("/say/{id}")
    public String say(@PathVariable("id") Integer id) {
        //return girlProperties.getCupSize();
        return "id: " + id;
    }

    /**
     * 经常用到
     * RequestParam注解还能设定是否必须和设置默认值。
     */
    /*@RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        //return girlProperties.getCupSize();
        return "id: " + id;
    }*/

}
