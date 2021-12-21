package com.atguigu.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DemoFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(DemoFilter.class);
 
    @Override
    public String filterType() {
        return "pre";  //枚举值：pre, routing, post, error
    }
 
    @Override
    public int filterOrder() {
        return 1;    //优先级， 0是最高优先级即最先执行
    }
 
    @Override
    public boolean shouldFilter() {
        return true;  //写逻辑，是否需要执行过滤。true会执行run函数，false不执行run函数
    }
 
    @Override
    public Object run() {
        logger.info("----------------this is DemoFilter----------");
 
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s %s", request.getMethod(), request.getRequestURL().toString()));
 
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {    //判断释放有token自动
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
 
            return null;
        }
        return null;
    }
}