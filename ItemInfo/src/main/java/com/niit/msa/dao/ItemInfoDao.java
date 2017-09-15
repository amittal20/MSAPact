package com.niit.msa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.msa.model.ItemInfo;;

@Repository
public interface ItemInfoDao extends CrudRepository<ItemInfo, Long> {
}
