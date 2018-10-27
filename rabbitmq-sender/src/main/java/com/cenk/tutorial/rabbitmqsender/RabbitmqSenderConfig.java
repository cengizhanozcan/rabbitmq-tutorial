package com.cenk.tutorial.rabbitmqsender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Rabbitmq sender config.
 */
@Configuration
public class RabbitmqSenderConfig {

    @Value("${cenk.tutorial.queueName}")
    private String queueName;

    @Value("${cenk.tutorial.topicExchangeName}")
    private String topicExchangeName;

    @Value("${cenk.tutorial.routingKey}")
    private String routingKey;

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
     * Exchange topic exchange.
     *
     * @return the topic exchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    /**
     * Binding binding.
     *
     * @param queue         the queue
     * @param topicExchange the topic exchange
     * @return the binding
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
    }
}
