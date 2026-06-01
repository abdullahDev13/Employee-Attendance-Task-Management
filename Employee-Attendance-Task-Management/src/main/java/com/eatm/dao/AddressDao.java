package com.eatm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Address;

@Repository
public class AddressDao {
	
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Address saveAddress(Address address) {
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		return address;
	}
	
	public Address deleteAddress(Address address) {
		entityTransaction.begin();
		entityManager.remove(address);
		entityTransaction.commit();
		return address;
	}

}

/*
 * controller----------service-----------------------dao
 * servlet methods	business logic(add,sub..)		db logic
 * 
 * in between these layer data has to be transfered
 * we cannot use entity object
 * instead use dto object : Data transfer object
 * dto is similar to entity but without any mapping and hibernate annotation
 */
