package com.spf.cloud.feign.service.impl;

import com.spf.cloud.feign.service.ScheduaServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-06-05 17:47
 */
@Component
public class SchedualServiceHiHystric implements ScheduaServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

}
