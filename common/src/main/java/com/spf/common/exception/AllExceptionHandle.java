package com.spf.common.exception;

import com.spf.common.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-26 19:13
 */
@ControllerAdvice(basePackages = {"com.spf"})
public class AllExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger (AllExceptionHandle.class);

    /**
     * 处理非法tenantId请求
     * */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object nullPointerExceptionHandler(NullPointerException e){
        return new Message<>().fail(e.getMessage());
    }


}
