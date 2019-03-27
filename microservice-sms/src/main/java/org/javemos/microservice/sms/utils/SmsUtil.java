package org.javemos.microservice.sms.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 */
@Component
public class SmsUtil {
	private static final String product = "Dysmsapi";
	private static final String domain = "dysmsapi.aliyuncs.com";

	@Autowired
	private Environment env;

	/**
	 * 发送短信
	 * @param mobile	手机号
	 * @param template_code	模板号
	 * @param sign_name	签名
	 * @param param	参数
	 * @return
	 */
	public SendSmsResponse sendSms(String mobile, String template_code, String sign_name, String param) throws ClientException {

		String accessKeyId = env.getProperty("accessKeyId");
		String accessKeySecret = env.getProperty("accessKeySecret");
		//调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化acsClient，暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou","cn-hangzhou",product,domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		//组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		request.setPhoneNumbers(mobile);
		request.setSignName(sign_name);
		request.setTemplateCode(template_code);
		request.setTemplateParam(param);

		return acsClient.getAcsResponse(request);
	}

	public QuerySendDetailsResponse querySendDetails(String mobile, String bizId) throws ClientException {
		String accessKeyId = env.getProperty("accessKeyId");
		String accessKeySecret = env.getProperty("accessKeySecret");
		//调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		//组装请求对象
		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
		request.setPhoneNumber(mobile);
		request.setBizId(bizId);	//流水号（可选）
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		request.setSendDate(sdf.format(new Date()));
		request.setPageSize(10L);
		request.setCurrentPage(1L);

		return acsClient.getAcsResponse(request);
	}

}
