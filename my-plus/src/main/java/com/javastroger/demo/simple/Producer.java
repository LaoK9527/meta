//package com.javastroger.demo.simple;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.MessageProperties;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * @author 老K
// */
//@Slf4j
//public class Producer {
//
//    public static void main(String[] args) {
//        extracted();
//
//
//    }
//
//    private static void extracted() {
//        //创建连接工程
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
//             connection = connectionFactory.newConnection("生产者");
//
//             //3、通过连接获取通道Channel
//             channel = connection.createChannel();
//
//             //4、通过创建交换机，声明队列，绑定关系，路由Key，发送消息，和接受消息
//            String queueName = "queuel";
//
//            /**
//             * 队列的名字
//             * 是否要持久化durable=false 持久化，是否存盘
//             * 排他性，是否是独占独立
//             * 是否自动删除，随着最后一个消费者完毕之后，是否删除
//             * 携带附属参数
//             */
//            channel.queueDeclare(queueName, false, false, false, null);
//
//            //5、准备消息内容
//            String message = "Hello Word";
//
//            //6、发送消息给队列queue
//            channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
//
//            log.info("消息发送成功:{}", message);
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
//
//}
