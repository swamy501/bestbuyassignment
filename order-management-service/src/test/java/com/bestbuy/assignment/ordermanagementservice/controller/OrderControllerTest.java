package com.bestbuy.assignment.ordermanagementservice.controller;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bestbuy.assignment.ordermanagementservice.model.Order;
import com.bestbuy.assignment.ordermanagementservice.repository.OrderRepository;

@RunWith(SpringRunner.class)
public class OrderControllerTest {

	@SpyBean
	private OrderController orderController;
	
	private List<Order> orders;
	
	@Before
	public void setUp(){
		Order o1 = new Order(ObjectId.get(),"Test Laptop","Test Laptop description",BigDecimal.valueOf(200L),1);
		Order o2 = new Order(ObjectId.get(),"Test Mobile","Test Mobile description",BigDecimal.valueOf(150L),1);
		orders.add(o1);
		orders.add(o2);
	}
	
	@Test
	public void TestGetAllOrders(){
		OrderRepository orderRepository = PowerMockito.mock(OrderRepository.class);
		Mockito.doReturn(orders).when(orderRepository).findAll();
		List<Order> mockOrders = orderController.getAllOrders();
		Assert.assertNotNull(mockOrders);
		Assert.assertEquals(this.orders.size(), mockOrders.size());
		Mockito.verify(orderRepository).findAll();
	}
	
}
