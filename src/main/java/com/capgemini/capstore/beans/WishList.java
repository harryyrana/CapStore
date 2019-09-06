package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_wishlist")
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wishlist_seq_gen")
	@SequenceGenerator(name = "wishlist_seq_gen", initialValue = 10000, sequenceName = "wishlist_seq")
	private long wishlistId;
	@OneToOne
	private Customer customer;
	@OneToMany
	private List<Product> products;

	public WishList() {
		super();
	}

	public WishList(long wishlistId, Customer customer, List<Product> products) {
		super();
		this.wishlistId = wishlistId;
		this.customer = customer;
		this.products = products;
	}

	@Override
	public String toString() {
		return "WishList [wishlistId=" + wishlistId + ", customer=" + customer + ", products=" + products + "]";
	}

	public long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}