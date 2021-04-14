package com.buildepidemicmonitoring.demo.flume;

import org.aopalliance.intercept.Interceptor;
import org.apache.flume.Context;
import org.apache.flume.Event;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义flume拦截器
 */

public class CustomTimeInterceptor implements Interceptor{

    //初始化方法
    @Override
    public void initialize(){

    }

    //单条拦截器
    /*
    1、解析event中的时间
    2、把时间转换成年月日信息 存入header
     */
    @Override
    public Event intercept(Event event){ //event分为header和body两部分，数据是在body中
        byte[] body=event.getBody();
        String msg=new String(body, StandardCharsets.UTF_8);

        //按照空格切分
        String[] arr=msg.split(" ");
        //因为有个文件没有是脏的，所以不能切分，所以我们需要判断
        String eventTime="";
        if (arr.length>11){
            eventTime=arr[4];
        }else {
            eventTime="unkoow";
        }

        //获取event中header，把event存入header
        Map<String,String> headers=event.getHeaders();
        headers.put("event_time",eventTime);

        //header存入event中
        event.setHeaders(headers);
        return event;
    }

    //批量拦截器
    @Override
    public List<Event> intercept(List<Event> events){

        //准备list集合接受拦截之后的event
        ArrayList<Event> list=new ArrayList<>();
        //循环遍历接收数据，然后调用单条批量处理逻辑
        for (Event event:events){
            Event newEvent=intercept(event);
            list.add(newEvent);
        }
        return list;
    }

    //关闭方法
    @Override
    public void close(){

    }

    //flume获取到自定拦截器要调用的方法
    public static class Builder implements Interceptor.Builder{

        //返回一个自定义拦截对象即可
        @Override
        public Interceptor build(){
            return new CustomTimeInterceptor();
        }

        @Override
        public void configure(Context context){

        }
    }

}
