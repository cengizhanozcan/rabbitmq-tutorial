package com.cenk.tutorial.rabbitmqreceiver;

import com.cenk.tutorial.rabbitmqreceiver.listener.MessageReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Rabbitmq receiver config.
 */
@Configuration
public class RabbitmqReceiverConfig {

    @Value("${cenk.tutorial.queueName}")
    private String queueName;

    @Value("${cenk.tutorial.topicExchangeName}")
    private String topicExchangeName;

    @Value("${cenk.tutorial.routingKey}")
    private String routingKey;

    /**
     * Exchange topic exchange.
     *
     * @return the topic exchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    /**
     * Queue queue.
     *
     * @return the queue
     */
    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    /**
     * Binding binding.
     *
     * @param queue    the queue
     * @param exchange the exchange
     * @return the binding
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    /**
     * Listener adapter message listener adapter.
     *
     * @param messageReceiver the message receiver
     * @return the message listener adapter
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(MessageReceiver messageReceiver) {
        return new MessageListenerAdapter(messageReceiver, "receiveMessage");
    }

    /**
     * Container simple message listener container.
     *
     * @param connectionFactory the connection factory
     * @param listenerAdapter   the listener adapter
     * @return the simple message listener container
     */
    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);

        return container;
    }

}
