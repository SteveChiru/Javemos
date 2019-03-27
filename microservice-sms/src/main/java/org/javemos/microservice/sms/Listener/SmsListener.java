package org.javemos.microservice.sms.Listener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.log4j.Logger;
import org.javemos.microservice.sms.utils.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 */
@Component
public class SmsListener {

	private static Logger logger = Logger.getLogger(SmsListener.class);

	@Autowired
	private SmsUtil smsUtil;

	@JmsListener(destination = "sms")
	public void sendSms(Map<String,String> map){
		try {
			SendSmsResponse response = smsUtil.sendSms(
					map.get("mobile"),
					map.get("template_code"),
					map.get("sign_name"),
					map.get("param"));
			logger.info("Code=" + response.getCode());
			logger.info("Message=" + response.getMessage());
			logger.info("RequestId=" + response.getRequestId());
			logger.info("BizId=" + response.getBizId());
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
