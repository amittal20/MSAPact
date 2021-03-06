package com.niit.msa.iteminvoice.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.niit.msa.iteminvoice.modal.Product;

@Configuration
public class ReceiverConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;
  
  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    return props;
  }
  
  

  @Bean
  public ConsumerFactory<String, Product> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
        new JsonDeserializer<>(Product.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Product> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Product> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());

    return factory;
  }
}
