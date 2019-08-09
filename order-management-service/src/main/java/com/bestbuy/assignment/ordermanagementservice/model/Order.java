package com.bestbuy.assignment.ordermanagementservice.model;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/***
 * 
 * @author AP301151
 *
 */
@AllArgsConstructor
@Setter
@Getter
@Document (collection ="order")
public class Order {	
	@Id
	private @NonNull ObjectId _id;
	private @NonNull String itemName;
	private @NonNull String itemDescription;
	private @NonNull BigDecimal itemPrice;
	private @NonNull int quantity;
	
	public Order(){
		
	}
	public Order(@NonNull ObjectId id, @NonNull String itemName,
			@NonNull String itemDescription, @NonNull BigDecimal itemPrice,
			@NonNull int quantity) {
		super();
		this._id = id;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
