//package com.spf.euraka_client.exception;
//
//import com.spf.common.entity.Message;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
///**
// * 全局异常处理
// */
//@ControllerAdvice(basePackages = {"com.spf"})
//public class EurekaClientExceptionHandler {
//
//	private final Logger logger = LoggerFactory.getLogger (EurekaClientExceptionHandler.class);
//
//	/**
//	 * 处理非法tenantId请求
//	 * */
//	@ExceptionHandler(NullPointerException.class)
//	@ResponseBody
//	public Object nullPointerExceptionHandler(NullPointerException e){
//        return new Message<>().fail(e.getMessage());
//	}
//
//}
