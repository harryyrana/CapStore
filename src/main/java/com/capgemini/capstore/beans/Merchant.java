package com.capgemini.capstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.capgemini.capstore.util.Status;

@Entity
@Table(name = "capstore_merchants")
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_seq_gen")
	@SequenceGenerator(name = "merchant_seq_gen", initialValue = 10000, sequenceName = "merchant_seq_gen")
	private long merchantId;
	@Column(length = 20)
	private String merchantName;
	@Column(length = 20)
	private String merchantPassword;
	@Size(max = 10, min = 10)
	private String merchantContactNo;
	@Column(length = 20)
	private String merchantGSTNo;
	@Column(length = 20)
	private String merchantCompanyName;
	private Status merchantStatus;
	private long merchantDiscount;
	@Column(length = 20)
	private int merchantQuestion;
	@Column(length = 20)
	private String merchantAnswer;

	/**
	 * @return the merchantId
	 */
	public long getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName
	 *            the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * @return the merchantPassword
	 */
	public String getMerchantPassword() {
		return merchantPassword;
	}

	/**
	 * @param merchantPassword
	 *            the merchantPassword to set
	 */
	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	/**
	 * @return the merchantContactNo
	 */
	public String getMerchantContactNo() {
		return merchantContactNo;
	}

	/**
	 * @param merchantContactNo
	 *            the merchantContactNo to set
	 */
	public void setMerchantContactNo(String merchantContactNo) {
		this.merchantContactNo = merchantContactNo;
	}

	/**
	 * @return the merchantGSTNo
	 */
	public String getMerchantGSTNo() {
		return merchantGSTNo;
	}

	/**
	 * @param merchantGSTNo
	 *            the merchantGSTNo to set
	 */
	public void setMerchantGSTNo(String merchantGSTNo) {
		this.merchantGSTNo = merchantGSTNo;
	}

	/**
	 * @return the merchantCompanyName
	 */
	public String getMerchantCompanyName() {
		return merchantCompanyName;
	}

	/**
	 * @param merchantCompanyName
	 *            the merchantCompanyName to set
	 */
	public void setMerchantCompanyName(String merchantCompanyName) {
		this.merchantCompanyName = merchantCompanyName;
	}

	
	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantName=" + merchantName + ", merchantPassword="
				+ merchantPassword + ", merchantContactNo=" + merchantContactNo + ", merchantGSTNo=" + merchantGSTNo
				+ ", merchantCompanyName=" + merchantCompanyName + ", merchantStatus=" + merchantStatus
				+ ", merchantDiscount=" + merchantDiscount + ", merchantQuestion=" + merchantQuestion
				+ ", merchantAnswer=" + merchantAnswer + "]";
	}

	public Merchant() {
		super();
	}

	public int getMerchantQuestion() {
		return merchantQuestion;
	}

	public void setMerchantQuestion(int merchantQuestion) {
		this.merchantQuestion = merchantQuestion;
	}

	public String getMerchantAnswer() {
		return merchantAnswer;
	}

	public void setMerchantAnswer(String merchantAnswer) {
		this.merchantAnswer = merchantAnswer;
	}

	public Merchant(long merchantId, String merchantName, String merchantPassword, String merchantContactNo,
			String merchantGSTNo, String merchantCompanyName, Status merchantStatus, long merchantDiscount,
			int merchantQuestion, String merchantAnswer) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.merchantPassword = merchantPassword;
		this.merchantContactNo = merchantContactNo;
		this.merchantGSTNo = merchantGSTNo;
		this.merchantCompanyName = merchantCompanyName;
		this.merchantStatus = merchantStatus;
		this.merchantDiscount = merchantDiscount;
		this.merchantQuestion = merchantQuestion;
		this.merchantAnswer = merchantAnswer;
	}

	public Status getMerchantStatus() {
		return merchantStatus;
	}

	public void setMerchantStatus(Status merchantStatus) {
		this.merchantStatus = merchantStatus;
	}

	/**
	 * @return the merchantDiscount
	 */
	public long getMerchantDiscount() {
		return merchantDiscount;
	}

	/**
	 * @param merchantDiscount
	 *            the merchantDiscount to set
	 */
	public void setMerchantDiscount(long merchantDiscount) {
		this.merchantDiscount = merchantDiscount;
	}

}
