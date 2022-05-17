//package com.javastroger.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
///**
// * @author 老K
// */
//@Configuration
//public class RabbitMqConfiguration {
//
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanout_order_exchange", true, false);
//    }
//
//    @Bean
//    public Queue duanxinQueue() {
//        return new Queue("duanxin_fanout_queue", true);
//    }
//
//    public Binding dunxinBinding() {
//        return BindingBuilder.bind(duanxinQueue()).to(fanoutExchange());
//    }
//
//}
