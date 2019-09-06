package com.capgemini.capstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_merchant_feedbacks")
public class MerchantFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_feedback_seq_gen")
	@SequenceGenerator(name = "merchant_feedback_seq_gen", initialValue = 10000, sequenceName = "merchant_feedback_seq")
	private long id;
	@Column(length = 256)
	private String response;
	@Column(length = 256)
	private String merchantFeedback;
	@ManyToOne
	private Merchant merchant;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getMerchantFeedback() {
		return merchantFeedback;
	}

	public void setMerchantFeedback(String merchantFeedback) {
		this.merchantFeedback = merchantFeedback;
	}

	public MerchantFeedback(long id, String merchantFeedback, Merchant merchant) {
		super();
		this.id = id;
		this.merchantFeedback = merchantFeedback;
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "MerchantFeedback [id=" + id + ", merchantFeedback=" + merchantFeedback + "]";
	}

	public MerchantFeedback() {

	}

}