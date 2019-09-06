package com.capgemini.capstore.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_coupons")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_seq_gen")
	@SequenceGenerator(name = "coupon_seq_gen", initialValue = 10000, sequenceName = "coupon_seq") // to be created
	private long couponId;
	@Column(length = 16)
	private String couponCode;
	private double minAmount;
	private double maxAmount;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Category category;
	@Column(length = 10)
	private float discountPercent;
	private Date generationDate;
	private Date expiryDate;

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", minAmount=" + minAmount
				+ ", maxAmount=" + maxAmount + ", product=" + product + ", category=" + category + ", discountPercent="
				+ discountPercent + ", generationDate=" + generationDate + ", expiryDate=" + expiryDate + "]";
	}

	public Coupon() {
		super();
	}

	public Coupon(long couponId, String couponCode, double minAmount, double maxAmount, Product product,
			Category category, float discountPercent, Date generationDate, Date expiryDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.product = product;
		this.category = category;
		this.discountPercent = discountPercent;
		this.generationDate = generationDate;
		this.expiryDate = expiryDate;
	}

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
