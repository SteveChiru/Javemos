package com.javemos.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class QueueController {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@RequestMapping("/send")
	public void send(String text){
		jmsMessagingTemplate.convertAndSend("spring_boot_inner_activemq_queue",text);
	}

	@RequestMapping("/sendmap")
	public void sendMap(){
		Map map = new HashMap();
		map.put("mobile","12339439024");
		map.put("content","恭喜获得10元代金券");
		jmsMessagingTemplate.convertAndSend("spring_boot_outer_activemq_queue",map);
	}

	@RequestMapping("/sendsms")
	public void sendSms(){
		Map map = new HashMap();
		map.put("mobile","13289219806");
		map.put("template_code","SMS_141655001");
		map.put("sign_name","普拉斯");
		map.put("param","{\"number\":\"123\"}");
		jmsMessagingTemplate.convertAndSend("sms",map);
	}
}
