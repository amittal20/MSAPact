package com.niit.msa.productservice;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import com.niit.msa.productservice.client.ItemInfoClient;
import com.niit.msa.productservice.model.ItemInfo;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ExampleJavaConsumerPactTest {
	@Rule
	public PactProviderRuleMk2 provider = new PactProviderRuleMk2("Item_Review_Service", "localhost",7954, this);

	
		@SuppressWarnings("deprecation")
		@Pact(provider = "Item_Review_Service", consumer = "Product_Service")
	    public RequestResponsePact createFragment(PactDslWithProvider builder) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return builder.uponReceiving("a request for Item review")
                .path("/GetItem/1")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"itemid\": 1, \"name\": \"Spider man\", \"price\": 20, \"category\": \"BOOK\"}")
                .toPact();

    }

		@Test
		@PactVerification("Item_Review_Service")
    public void runTest() {
		String url = provider.getConfig().url();	
        URI productDetailsUri = URI.create(String.format("%s/%s/%s", url, "GetItem", 1));

        ItemInfoClient productDetailsFetcher = new ItemInfoClient();
        ItemInfo productDetails =  productDetailsFetcher.fetchDetails(productDetailsUri);
        assertTrue(productDetails.getItemid()==1L);
    }
}