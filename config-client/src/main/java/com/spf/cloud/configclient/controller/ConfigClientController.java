package com.spf.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-06-07 14:51
 */
@RestController
public class ConfigClientController {

    @Value("${foo}")
    String foo;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

    @RequestMapping(value = "/port")
    public String port(){
        return port;
    }

}
