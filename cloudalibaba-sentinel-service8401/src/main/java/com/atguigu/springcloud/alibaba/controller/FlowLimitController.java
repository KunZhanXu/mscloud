package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * @auther zzyy
 * @create 2020-01-09 16:34
 */
@RestController
@Slf4j
public class FlowLimitController
{
    @Autowired
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    @GetMapping("/testCommonA")
    public String testCommonA()
    {
        return  flowLimitService.common();
    }

    @GetMapping("/testCommonB")
    public String testCommonB()
    {
        return  flowLimitService.common();
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHostKey",blockHandler = "dealHandler_testHotKey")
    public String testHostKey(@RequestParam(value = "p1",required = false) String p1,
                              @RequestParam(value = "p2",required = false) String p2){
        return  "------testHotKey";
    }
    public String dealHandler_testHotKey(String p1, String p2, BlockException exception)
    {
        return "-----dealHandler_testHotKey";
    }

}
 
 

