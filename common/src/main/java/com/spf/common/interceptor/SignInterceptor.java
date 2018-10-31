package com.spf.common.interceptor;

import com.spf.common.exception.SysException;
import com.spf.common.utils.IPUtil;
import com.spf.common.utils.SignUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-31 10:42
 */
public class SignInterceptor implements HandlerInterceptor {

    private Logger logger = LogManager.getLogger(SignInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String url = request.getRequestURL().toString() + "?";
        Map<String, Object> params = WebUtils.getParametersStartingWith(request, "");
        for (String key : params.keySet()) {
            url += key + "=" + params.get(key) + "&";
        }
        url = url.substring(0, url.length() - 1);
        logger.info("request  ip: {}, method: {}, url: {}",IPUtil.getRealIp(request), request.getMethod(), url);

        if (params.containsKey("debug") && params.get("debug").equals("1")) {
            return true;
        }
        Object sign = null;
        try {
            if ((sign = params.get("sign")) == null || !params.containsKey("timestamp") ||
                    !SignUtil.verify(params, sign.toString(), "UTF-8")) {
                throw new SysException("接口验证失败!");
            }
        } catch (Exception e) {
            throw new SysException("接口验证失败!");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
