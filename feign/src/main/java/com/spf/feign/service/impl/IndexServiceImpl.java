package com.spf.feign.service.impl;

import com.spf.feign.service.IndexService;
import org.springframework.stereotype.Component;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-24 18:55
 */
@Component
public class IndexServiceImpl implements IndexService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }

}
