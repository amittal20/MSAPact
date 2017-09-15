package com.niit.msa.productservice.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.niit.msa.productservice.client.ItemInfoClient;
import com.niit.msa.productservice.client.ItemReviewClient;
import com.niit.msa.productservice.model.ItemInfo;
import com.niit.msa.productservice.model.Product;

@Controller
public class MyController {

	@Autowired
	private ItemReviewClient itemRevieClient;
	
	@Autowired
	private ItemInfoClient itemInfoClient;
	

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired KafkaSender sender;

	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@RequestMapping("/GetProduct/{itemid}")
	public @ResponseBody Product sayHello(@PathVariable("itemid") Long itemid) {
		URI productDetailsUri = URI.create(String.format("%s/%s/%s", "http://ITEMINFO-SERVICE", "GetItem", itemid));
        ItemInfo item = itemInfoClient.fetchDetails(productDetailsUri);
		logger.info("..............Inside product controller");
		logger.info("..............ItemInfo" + item.toString());
		String reviews = itemRevieClient.getItemReview(itemid);
		Product product = new Product();
		product.setItemid(item.getItemid());
		product.setProductName(item.getCategory() + "-" + item.getName());
		product.setReviews(reviews);
		logger.info("..............Product" + product.toString());
		sender.send("invoice", product);
		
		logger.info("Message sent to kafka");
		return product;
	}

}
