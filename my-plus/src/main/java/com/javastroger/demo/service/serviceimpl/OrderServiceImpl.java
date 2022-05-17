/*
package com.javastroger.demo.service.serviceimpl;

import com.javastroger.demo.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

*/
/**
 * @author 老K
 *//*

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void makeOrder(String userId, String num) {

        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功" + orderId);

        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }
}
*/
