package com.capgemini.capstore.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_account_details")
public class AccountDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_seq_gen")
	@SequenceGenerator(name = "detail_seq_gen", initialValue = 10000, sequenceName = "detail_seq")
	private String cardNo;
	private String cardholderName;
	private String cvv;
	private Date expDate;
	@OneToOne
	private Customer customer;
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public AccountDetail() {
		super();
	}

	public AccountDetail(String cardNo, String cardholderName, String cvv, Date expDate) {
		super();
		this.cardNo = cardNo;
		this.cardholderName = cardholderName;
		this.cvv = cvv;
		this.expDate = expDate;
	}

}