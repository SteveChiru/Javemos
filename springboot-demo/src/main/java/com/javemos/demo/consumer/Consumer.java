package com.javemos.demo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 */
@Component
public class Consumer {

	@JmsListener(destination = "spring_boot_inner_activemq_queue")
	public void readMessage(String text){
		System.out.println("接收到消息："+text);
	}

	@JmsListener(destination = "spring_boot_outer_activemq_queue")
	public void readMap(Map map){
		System.out.println(map);
	}
}
