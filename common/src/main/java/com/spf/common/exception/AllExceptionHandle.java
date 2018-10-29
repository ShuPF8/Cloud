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
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object nullPointerExceptionHandler(RuntimeException e){
        return setup(e);
    }

    private Message setup(Exception e){
        logger.info ("------本次请求抛出了一个{}异常，请求结束------\n",e.getClass ());
        logger.error("", e);

        Message result = new Message ();
        //有异常就直接判失败
        result.fail(e.getMessage());
        return result;
    }

}
