import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @Description:
 */
public class QueueConsumer {

	public static void main(String[] args) throws JMSException, IOException, InterruptedException {
		//1.创建连接对象
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://cloudserver:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		//2.获取Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//3.创建队列
		Queue queue = session.createQueue("test-queue");
		//4.创建消费对象
		MessageConsumer consumer = session.createConsumer(queue);

		//7.监听消息
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				TextMessage textMessage=(TextMessage)message;
				try {
					System.out.println("接收到消息："+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		System.in.read();
		//7.关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
}
