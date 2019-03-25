import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Description:
 */
public class QueueProducer {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://cloudserver:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		//获取session（参数1：是否启动事务，参数2：消息确认模式）
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test-queue");
		TextMessage textMessage = session.createTextMessage("消息队列activemq-点对点模式");
		MessageProducer producer = session.createProducer(queue);
		producer.send(textMessage);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
	}
}
