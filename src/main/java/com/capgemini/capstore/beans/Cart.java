package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq_gen")
	@SequenceGenerator(name = "cart_seq_gen", initialValue = 10000, sequenceName = "cart_seq") // to be created
	private long cartId;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Product> products;

	public Cart() {
		super();
	}

	public Cart(long cartId, List<Product> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
