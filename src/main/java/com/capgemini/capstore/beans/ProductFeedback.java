package com.capgemini.capstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.capgemini.capstore.util.Rating;

@Entity
@Table(name = "capstore_product_feedback")
public class ProductFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_feedback_seq_gen")
	@SequenceGenerator(name = "product_feedback_seq_gen", initialValue = 10000, sequenceName = "product_feedback_seq")
	private long id;
	@Column(length = 256)
	private String feedBack;
	@ManyToOne
	private Product product;
	@OneToOne
	private Customer customer;
	private Rating rating;


	public ProductFeedback(long id, String feedBack, Product product, Customer customer, Rating rating) {
		super();
		this.id = id;
		this.feedBack = feedBack;
		this.product = product;
		this.customer = customer;
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "ProductFeedback [id=" + id + ", feedBack=" + feedBack + ", product=" + product + ", rating=" + rating
				+ "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFeedBack() {
		return feedBack;
	}


	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}


	public ProductFeedback() {
		super();
	}

}