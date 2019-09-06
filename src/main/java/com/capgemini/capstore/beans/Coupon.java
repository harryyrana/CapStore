package com.capgemini.capstore.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_coupons")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_seq_gen")
	@SequenceGenerator(name = "coupon_seq_gen", initialValue = 10000, sequenceName = "coupon_seq") // to be created
	private long couponId;
	@Column(length = 20)
	private String couponCode;
	@Column(length = 10)
	private float discountPercent;
	private Date generationDate;
	private Date expiryDate;
	public Coupon(long couponId, String couponCode, float discountPercent, Date generationDate, Date expiryDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.discountPercent = discountPercent;
		this.generationDate = generationDate;
		this.expiryDate = expiryDate;
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
