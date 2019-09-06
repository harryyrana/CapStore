package com.capgemini.capstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.capgemini.capstore.util.Status;


@Entity
@Table(name = "capstore_customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq_gen")
	@SequenceGenerator(name = "cust_seq_gen", initialValue = 10000, sequenceName = "cust_seq") // to be created
	private long customerId;
	@Column(length = 20)
	private String customerName;
	@Column(length = 20)
	private String customerPassword;
	@Column(length = 20)
	private String customerContactNo;
	@Column(length = 100)
	private String customerAddress;
	private Status customerStatus;
	private int customerQuestion;
	private String customerAnswer;
	

	public Customer() {
		super();
	}

	
    

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", customerContactNo=" + customerContactNo + ", customerAddress=" + customerAddress
				+ ", customerStatus=" + customerStatus + ", customerQuestion=" + customerQuestion + ", customerAnswer="
				+ customerAnswer + "]";
	}
	
	




	/**
	 * @return the customerQuestion
	 */

	public int getCustomerQuestion() {
		return customerQuestion;
	}


	/**
	 * @param customerQuestion
	 *            the customerQuestion to set
	 */

	public void setCustomerQuestion(int customerQuestion) {
		this.customerQuestion = customerQuestion;
	}

	/**
	 * @return the customerAnswer
	 */


	public String getCustomerAnswer() {
		return customerAnswer;
	}


	/**
	 * @param customerAnswer
	 *            the customerAnswer to set
	 */



	public void setCustomerAnswer(String customerAnswer) {
		this.customerAnswer = customerAnswer;
	}




	public Customer(long customerId, String customerName, String customerPassword, String customerContactNo,
			String customerAddress, Status customerStatus, int customerQuestion, String customerAnswer) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerContactNo = customerContactNo;
		this.customerAddress = customerAddress;
		this.customerStatus = customerStatus;
		this.customerQuestion = customerQuestion;
		this.customerAnswer = customerAnswer;
	}




	/**
	 * @return the cutomerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param cutomerId
	 *            the cutomerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * @param customerPassword
	 *            the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * @return the customerContactNo
	 */
	public String getCustomerContactNo() {
		return customerContactNo;
	}

	/**
	 * @param customerContactNo
	 *            the customerContactNo to set
	 */
	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress
	 *            the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Status getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Status customerStatus) {
		this.customerStatus = customerStatus;
	}

}
