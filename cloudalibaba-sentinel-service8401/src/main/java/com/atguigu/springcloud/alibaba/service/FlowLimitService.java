package com.atguigu.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitService {


    @SentinelResource("common")
    public String common(){
        return "我是链路模式的公共调用方法！";
    }

}
