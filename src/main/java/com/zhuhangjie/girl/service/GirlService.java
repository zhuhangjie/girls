package com.zhuhangjie.girl.service;

import com.zhuhangjie.girl.entity.Girl;
import com.zhuhangjie.girl.enums.ResultEnum;
import com.zhuhangjie.girl.exception.GirlException;
import com.zhuhangjie.girl.repository.GirlRepository;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setCupSize("BA");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw  new GirlException(ResultEnum.PRIMART_SCHOOL);
        } else if(age > 10 && age < 16) {
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOLE);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
