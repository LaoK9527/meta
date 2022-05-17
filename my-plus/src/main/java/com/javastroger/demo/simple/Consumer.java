//package com.javastroger.demo.simple;
//
//import com.rabbitmq.client.*;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.concurrent.TimeoutException;
//
///**
// * @author 老K
// */
//@Slf4j
//public class Consumer {
//
//    public static void main(String[] args) {
//        extracted();
//
//    }
//
//    private static void extracted() {
//        //1、创建连接工程
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("192.168.56.1");
//        connectionFactory.setPort(5672);
//        connectionFactory.setUsername("admin");
//        connectionFactory.setPassword("admin");
//        connectionFactory.setVirtualHost("/");
//
//        //2、创建连接
//        Connection connection = null;
//        Channel channel = null;
//        try {
//            connection = connectionFactory.newConnection("生产者");
//
//            //3、通过连接获取通道Channel
//            channel = connection.createChannel();
//
//            //4、通过创建交换机，声明队列，绑定关系，路由Key，发送消息，和接受消息
//            channel.basicConsume("queuel", true, new DeliverCallback() {
//                @Override
//                public void handle(String s, Delivery message) throws IOException {
//                    log.info("收到消息:{}", new String(message.getBody(), Charset.defaultCharset()));
//                }
//            }, new CancelCallback() {
//                @Override
//                public void handle(String s) throws IOException {
//                    log.info("异常:{}", s);
//                }
//            });
//            log.info("消息接受送成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } finally {
//            //7、关闭通道
//            if (channel != null && channel.isOpen()) {
//                try {
//                    channel.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            //8、关闭连接
//            if (connection != null && connection.isOpen()) {
//                try {
//                    connection.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }
//}
