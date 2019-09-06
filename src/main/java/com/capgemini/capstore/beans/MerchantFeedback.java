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

import com.capgemini.capstore.util.MerchantFeedbackStatus;

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
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant;
	private MerchantFeedbackStatus status;
	private String adminComment;
	@ManyToOne
	private Customer customer;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public MerchantFeedbackStatus getStatus() {
		return status;
	}

	public void setStatus(MerchantFeedbackStatus status) {
		this.status = status;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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

	public MerchantFeedback() {
	}

	public MerchantFeedback(long id, String response, String merchantFeedback, Merchant merchant,
			MerchantFeedbackStatus status, String adminComment, Customer customer) {
		super();
		this.id = id;
		this.response = response;
		this.merchantFeedback = merchantFeedback;
		this.merchant = merchant;
		this.status = status;
		this.adminComment = adminComment;
		this.customer = customer;
	}

}