package com.atguigu.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Demo1Filter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(DemoFilter.class);
 
    @Override
    public String filterType() {
        return "pre";  //枚举值：pre, routing, post, error
    }
 
    @Override
    public int filterOrder() {
        return 0;    //优先级, 0是最高优先级即最先执行
    }
 
    @Override
    public boolean shouldFilter() {
        return true;  //写逻辑，是否需要执行过滤。true会执行run函数，false不执行run函数
    }
 
    @Override
    public Object run() {
        logger.info("----------------this is Demo1Filter----------");
        return null;
    }
}