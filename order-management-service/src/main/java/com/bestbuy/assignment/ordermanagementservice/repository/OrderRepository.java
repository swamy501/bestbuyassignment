package com.bestbuy.assignment.ordermanagementservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bestbuy.assignment.ordermanagementservice.model.Order;

/**
 * 
 * @author AP301151
 *
 */
public interface OrderRepository extends MongoRepository<Order, String>{

	Order findBy_id(ObjectId _id);
}
