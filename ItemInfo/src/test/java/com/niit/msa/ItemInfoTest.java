package com.niit.msa;

import static org.junit.Assert.assertEquals;

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
@SpringBootTest(classes = ItemInfoApplication.class, 
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemInfoTest {

	@LocalServerPort
	private int port;

	TestRestTemplate testTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void getItemInfoTest() throws JSONException {
		headers.add("Accept", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = testTemplate.exchange(getUrl("/GetItem/1"), HttpMethod.GET, entity,
				String.class);
		assertEquals(200, response.getStatusCode().value());
		String expectedResult = "{itemid:1,name:'Spider man',price:20,category:'BOOK'}";
		JSONAssert.assertEquals(expectedResult, response.getBody(), false);
	}

	private String getUrl(String uri) {
		return "http://localhost:" + port + uri;
	}

}
