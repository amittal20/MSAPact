package com.niit.msa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.niit.msa.dao.ItemReviewDao;
import com.niit.msa.model.ItemReview;

@Controller
public class MyController {
	
	@Autowired
	ItemReviewDao dao;
	private static final Logger logger = LoggerFactory.getLogger("ItemReviewController");

	
	@RequestMapping(value="/GetItemReview/{itemid}", method=RequestMethod.GET, produces="application/Json")
	@ResponseBody public String sayHello(@PathVariable("itemid") Long itemid) {
		logger.debug("...... hello review for "+itemid);
		Iterable<ItemReview> persons = dao.getReviewsByItem(itemid);
		//StringBuilder build = new StringBuilder("");
		return Lists.newArrayList(persons)
					.stream()
					.map((value)->value.getMessage())
					.reduce("", (a,b)->a+ "[" +b+ "]");
	}

}
