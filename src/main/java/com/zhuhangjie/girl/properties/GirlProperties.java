package com.zhuhangjie.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 该类可以把在application.yml中对应前缀的属性给映射过来
 * 注意要加一个Component配置和ConfigurationProperties和前缀，起到了一个分组的作用
 * 项目中一定要分组不然会很乱！！！！
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cupSize;
    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
