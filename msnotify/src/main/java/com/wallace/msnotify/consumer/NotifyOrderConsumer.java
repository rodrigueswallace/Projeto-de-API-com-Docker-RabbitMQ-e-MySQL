package com.wallace.msnotify.consumer;

import com.wallace.msnotify.dto.MessageDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class NotifyOrderConsumer {

    @RabbitListener(queues = "orders.v1.order-status")
    public void  onOrderStatus(MessageDTO messageDTO){
        System.out.println("Usarname: " + messageDTO.getUsername());
        System.out.println("Operation: " + messageDTO.getOperation());
        System.out.println("------------------");


    }
}
