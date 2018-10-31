package com.spf.euraka_client.interceptor;

import com.spf.common.interceptor.SignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-22 15:38
 */
@Configuration
public class InterceptorConfig {

    @Bean("requestSignInterceptor")
    public MappedInterceptor requestSignInterceptor(){
        MappedInterceptor requestSignInterceptor = new MappedInterceptor(
                new String[] { "/**" },
                new SignInterceptor());
        return requestSignInterceptor;
    }

}
