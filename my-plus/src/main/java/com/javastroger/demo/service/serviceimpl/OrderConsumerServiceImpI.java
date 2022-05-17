//package com.javastroger.demo.service.serviceimpl;
//
//import com.javastroger.demo.service.OrderConsumerService;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
///**
// * @author 老K
// */
//@Service
//@RabbitListener(queues = {"duanxin_fanout_queue"})
//public class OrderConsumerServiceImpI implements OrderConsumerService {
//
//    @RabbitHandler
//    @Override
//    public void acceptMessage(String message) {
//        System.out.println("接收到订单信息" + message);
//    }
//}
