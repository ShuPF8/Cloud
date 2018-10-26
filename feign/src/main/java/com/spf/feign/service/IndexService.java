package com.spf.feign.service;

import com.spf.feign.service.impl.IndexServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-24 18:32
 */
@FeignClient(value = "euraka-client", fallback = IndexServiceImpl.class)
public interface IndexService {

    @RequestMapping(value = "/index/home",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
