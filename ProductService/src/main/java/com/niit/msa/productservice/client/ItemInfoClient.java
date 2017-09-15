package com.niit.msa.productservice.client;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.niit.msa.productservice.model.ItemInfo;

@Component
public class ItemInfoClient {
	
	

	    public ItemInfo fetchDetails(URI itemInfoUri) {
	        return new RestTemplate().getForObject(itemInfoUri,
	                ItemInfo.class);


	    }

	
}
