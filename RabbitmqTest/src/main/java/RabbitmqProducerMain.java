import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeUnit;

public class RabbitmqProducerMain {
    /**
     * 作者：panda-star
     * 来源：CSDN
     * 原文：https://blog.csdn.net/chinabestchina/article/details/72824541
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.58.99");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123456");
        //factory.setVirtualHost("vhostOne");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        String queueName = "queueOne";
        String exchangeName = "exchangerOne";
        String routingKey = "queueOne";
        channel.exchangeDeclare(exchangeName, "direct");
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        int msgCnt = 15000;
        while (msgCnt-- > 0) {
            String msg = "msg" + Math.random() * 100;
            channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());  //发送消息
            System.out.println("produce msg :" + msg);
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 500));
        }
        channel.close();
        connection.close();
    }
}


