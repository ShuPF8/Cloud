package com.spf.feign.controller;

import com.spf.feign.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-24 18:35
 */
@RestController
public class IndexFeiGnController {

    @Autowired
    private IndexService indexService;

    @Value("${spring.application.name}")
    String name;

    @RequestMapping(value = "hi")
    public Object sayHi(@RequestParam(value = "name") String name) {
        return indexService.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "name")
    public Object host() {
        return name;
    }

}
