package com.spf.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-26 17:14
 */
@Component
public class RequertFiter extends ZuulFilter {

    private Logger logger = LogManager.getLogger(RequertFiter.class);

    /**
     * 返回一个字符串代表过滤器的类型
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        logger.info("-------------------------------------- {}", "filterType");
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        logger.info("-------------------------------------- {}", "filterOrder");
        return 0;
    }

    /**
     * 写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        logger.info("-------------------------------------- {}", "shouldFilter");
        return false;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        logger.info("-------------------------------------- {}", "run");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        logger.info("ok");
        return null;
    }
}
