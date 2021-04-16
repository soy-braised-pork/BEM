package com.buildepidemicmonitoring.demo.flume;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.Charset;

public class MyRpcClinetFacade {

    private RpcClient client;
    private String hostname;
    private int port;

    public MyRpcClinetFacade(String hostname,int port){
        this.hostname=hostname;
        this.port=port;
        this.client= RpcClientFactory.getDefaultInstance(hostname,port);
    }

    public void sendDataToFlume(String data){

        //创建封装示例数据的Flume事件对象
        Event event= EventBuilder.withBody(data, Charset.forName("UTF-8"));

        //发送事件
        try {
            client.append(event);
        }catch (EventDeliveryException e){
            client.close();
            client=null;
            this.client=RpcClientFactory.getThriftInstance(hostname,port);

        }
    }

    public void cleanUp(){
        client.close();
    }
}
