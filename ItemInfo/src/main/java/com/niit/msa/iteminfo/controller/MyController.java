package com.niit.msa.iteminfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.niit.msa.dao.ItemInfoDao;
import com.niit.msa.model.ItemInfo;

@Controller
public class MyController {

	@Autowired
	ItemInfoDao dao;

	private static final Logger logger = LoggerFactory.getLogger("ItemInfoController");

	@RequestMapping(value="/GetItem/{id}", method=RequestMethod.GET, produces={"application/json"})
	@HystrixCommand(fallbackMethod = "fallbackGetItem")
	public @ResponseBody ItemInfo sayHello(@PathVariable("id") Long id) {
		logger.info("..........Inside Intem info controller " + id);
		ItemInfo item = dao.findOne(id);
		if (item.getName() == null) {
			throw new RuntimeException("Item not found!");
		}
		return item;
	}

	public ItemInfo fallbackGetItem(Long id) {
		logger.info("..........Inside getItem fallback");
		return new ItemInfo(0L, "dummyItem", 0, "any");
	}
}
