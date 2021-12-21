package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @auther zzyy
 * @create 2019-12-10 13:01
 */
public class CustomerBlockHandler
{
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
}