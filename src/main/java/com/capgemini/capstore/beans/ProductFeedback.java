package com.capgemini.capstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "capstore_product_feedback")
public class ProductFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_feedback_seq_gen")
	@SequenceGenerator(name = "product_feedback_seq_gen", initialValue = 10000, sequenceName = "product_feedback_seq")
	private long productFeedbackId;
	@Column(length = 256)
	private String feedBack;
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	@Max(value = 5)
	private int rating;

	public ProductFeedback(long productFeedbackId, String feedBack, Product product, Customer customer,
			@Max(5) int rating) {
		super();
		this.productFeedbackId = productFeedbackId;
		this.feedBack = feedBack;
		this.product = product;
		this.customer = customer;
		this.rating = rating;
	}

	public long getProductFeedbackId() {
		return productFeedbackId;
	}

	public void setProductFeedbackId(long productFeedbackId) {
		this.productFeedbackId = productFeedbackId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public ProductFeedback() {
		super();
	}

}