package com.niit.msa.iteminvoice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.niit.msa.iteminvoice.modal.Product;

@Component
public class KafkaConsumer {
	 private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	
	 public void receive(String topic, String payload) {
		    LOGGER.info("Received payload='{}' to topic='{}'", payload, topic);
		   // latch. .(topic, payload);
		  }
	 
	 @KafkaListener(topics="invoice")
	    public void processMessage(Product content) {
		 	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	LOGGER.info("received content = '{}'", content);
			//storage.put(content);
	    }

}
