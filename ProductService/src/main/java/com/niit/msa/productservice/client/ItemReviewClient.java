package com.niit.msa.productservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "http://ITEMREVIEW-SERVICE",
					fallback = ItemReviewClient.ItemReviewClientFallback.class)
public interface ItemReviewClient {

	@RequestMapping(value = "/GetItemReview/{id}")
	String getItemReview(@PathVariable("id") Long id);

	@Component
	public static class ItemReviewClientFallback implements ItemReviewClient {
		@Override
		public String getItemReview(Long id) {
			return "Returning Item Review for " + id + " - fallback";
		}
	}
}
