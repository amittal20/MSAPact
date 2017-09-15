package com.niit.msa.productservice;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductApplicationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate testTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void getProductTest() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = testTemplate.exchange(getUrl("/getProduct/id/28"), HttpMethod.GET, entity,
				String.class);
		String ecpectedResult = "{}";
		JSONAssert.assertEquals(ecpectedResult, response.getBody(), false);
	}

	private String getUrl(String uri) {
		return "http://localhost:" + port + uri;
	}

}
