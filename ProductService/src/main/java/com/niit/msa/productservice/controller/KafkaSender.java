package com.niit.msa.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.niit.msa.productservice.model.Product;

@Component
public class KafkaSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

  @Autowired
  private KafkaTemplate<String, Product> kafkaTemplate;

  public void send(String topic, Product payload) {
    LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
    kafkaTemplate.send(topic, payload);
  }
}