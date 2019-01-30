package com.zhuhangjie.girl.controller;

import com.zhuhangjie.girl.aspect.HttpAspect;
import com.zhuhangjie.girl.entity.Girl;
import com.zhuhangjie.girl.entity.Result;
import com.zhuhangjie.girl.repository.GirlRepository;
import com.zhuhangjie.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/girls")
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 查询女生列表
     * @return
     */
    @GetMapping
    public List<Girl> girlList() {
        logger.info("调用girlList");
        return girlRepository.findAll();
    }
    /**
     * 添加一个女生
     * @return
     */
    @PostMapping
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping("/{id}")
    public Girl girlFind(@PathVariable("id")Integer id) {
        Girl g = girlRepository.findOne(id);
        return g;
    }

    @PutMapping("/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,
                               @RequestParam(value = "cupSize", required = false, defaultValue = "-1")String cupSize,
                               @RequestParam(value = "age", required = false, defaultValue = "-1")Integer age
                               ) {

        Girl g = new Girl();
        g.setId(id);
        if (cupSize != null && cupSize != "-1"){
            g.setCupSize(cupSize);
        }
        if (age != null && age != -1) {
            g.setAge(age);
        }

        return girlRepository.save(g);
    }

    @DeleteMapping("/{id}")
    public void girlDelete(@PathVariable("id")Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("/age/{age}")
    public List<Girl> findByAge(@PathVariable("age")Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception{
        girlService.getAge(id);
    }
}
