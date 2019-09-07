package com.capgemini.capstore.beans;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "capstore_stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
	@SequenceGenerator(name = "product_seq_gen", initialValue = 10000, sequenceName = "product_seq")
	private long id;
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	private int available;
	private int totalQuantity;

	public Stock() {
		super();
	}

	public Stock(long id, Product product, int available, int totalQuantity) {
		super();
		this.id = id;
		this.product = product;
		this.available = available;
		this.totalQuantity = totalQuantity;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
