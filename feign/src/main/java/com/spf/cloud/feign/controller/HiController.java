package com.spf.cloud.feign.controller;

import com.spf.cloud.feign.service.ScheduaServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-06-01 15:06
 */
@RestController
public class HiController {

    @Resource private ScheduaServiceHi scheduaServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return scheduaServiceHi.sayHiFromClientOne(name);
    }

}
