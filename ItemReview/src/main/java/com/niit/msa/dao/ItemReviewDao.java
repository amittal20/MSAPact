package com.niit.msa.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niit.msa.model.ItemReview;;

@Repository
public interface ItemReviewDao extends CrudRepository<ItemReview, Long> {

	@Query("FROM ItemReview i WHERE i.itemid = :itemid")
	Iterable<ItemReview> getReviewsByItem(@Param("itemid") Long itemid);
}
