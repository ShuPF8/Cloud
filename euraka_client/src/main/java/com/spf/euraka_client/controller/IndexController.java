package com.spf.euraka_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-24 16:56
 */
@RestController
@RequestMapping(value = "index")
public class IndexController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "home")
    public Object home(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping(value = "exception")
    public Object exception() {
        int a = 2, b = 1;
        if (a > b) {
            throw new NullPointerException("系统空指针异常测试");
        }
        return null;
    }

}
