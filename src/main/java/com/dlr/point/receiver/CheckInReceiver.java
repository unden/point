package com.dlr.point.receiver;

import com.alibaba.fastjson.JSON;
import com.dlr.point.dto.PointMqMessage;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CheckInReceiver {

    @RabbitListener(queues = "point")
    public void process2(Channel channel, Message message) {
        String s = new String(message.getBody());

        PointMqMessage pointMqMessage = JSON.parseObject(s, PointMqMessage.class);
        System.out.println(JSON.toJSONString(pointMqMessage, true));
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            System.out.println(JSON.toJSONString(e, true));
        }
    }

}
