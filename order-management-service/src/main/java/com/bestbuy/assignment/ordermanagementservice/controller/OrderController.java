package com.bestbuy.assignment.ordermanagementservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestbuy.assignment.ordermanagementservice.model.Order;
import com.bestbuy.assignment.ordermanagementservice.repository.OrderRepository;

/***
 * 
 * @author AP301151
 *
 */
@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	/***
	 * Get List of all orders
	 * @return
	 */
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		Iterable<Order> result = orderRepository.findAll();
		List<Order> orderList = new ArrayList<Order>();
		result.forEach(orderList::add);
		return orderList;
	}
	
	/***
	 * Get Order by orderid
	 * @param id
	 * @return
	 */
	@GetMapping("/order/{Id}")
	public Order getOrder(@PathVariable ObjectId Id){
		Order order = orderRepository.findBy_id(Id);
		return order;
	}
	
	/***
	 * Update an order
	 * @param newOrder
	 * @param Id
	 * @return
	 */
	@PutMapping("/order/{Id}")
	public Order updateOrder(@RequestBody Order newOrder, @PathVariable ObjectId Id) {
		Order order = orderRepository.findBy_id(Id);
		if(order != null) {
			order.setItemName(newOrder.getItemName());
			order.setItemDescription(newOrder.getItemDescription());
			order.setItemPrice(newOrder.getItemPrice());
			order.setQuantity(newOrder.getQuantity());
			orderRepository.save(order);
		}
		return order;
	}
	
	/***
	 * delete order by Id
	 * @param Id
	 * @return
	 */
	@DeleteMapping(value="/order/{Id}",produces = "application/json;charset=utf-8")
	public String deleteOrder(@PathVariable ObjectId Id) {
		Boolean result = (orderRepository.findBy_id(Id) != null) ? true: false;
		orderRepository.delete(orderRepository.findBy_id(Id));
		return "{\"success\": "+result+"}";
	}
	
	/***
	 * Add an order
	 * @param newOrder
	 * @return
	 */
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order newOrder) {
		Order order = new Order(ObjectId.get(),
				                newOrder.getItemName(),
				                newOrder.getItemDescription(),
				                newOrder.getItemPrice(),
				                newOrder.getQuantity());
		orderRepository.save(order);
		return order;
	}
	
	
	/***
	 * healthcheck method
	 * @return
	 */
	@GetMapping(value="/healthcheck", produces="application/json;charset=utf-8")
	public String getHealthCheck(){
		return "{\"success\": true}";
	}
}
