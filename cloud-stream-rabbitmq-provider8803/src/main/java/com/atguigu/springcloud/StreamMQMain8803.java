package com.atguigu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @auther zzyy
 * @create 2020-02-08 15:57
 */
@SpringBootApplication
public class StreamMQMain8803
{
    public static void main(String[] args)
    {
        SpringApplication.run(StreamMQMain8803.class,args);
    }
}
 
 

