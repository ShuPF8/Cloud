package com.spf.cloud.feign.service;

import com.spf.cloud.feign.service.impl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-06-01 15:03
 */
@FeignClient(value = "SERVICE-SPF-1", fallback = SchedualServiceHiHystric.class)
public interface ScheduaServiceHi {

    @RequestMapping(value = "/indexController/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
