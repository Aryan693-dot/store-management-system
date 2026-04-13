package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer i_id;
	private String name;
	private Double price;
	private Integer quantity;
	private Integer sold = 0;
	
	@ManyToOne
	private Store store;

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	public Integer getSold() {
	    return sold;
	}

	public void setSold(Integer sold) {
	    this.sold = sold;
	}

	
}
