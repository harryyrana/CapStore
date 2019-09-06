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

@Entity
@Table(name = "capstore_invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq_gen")
	@SequenceGenerator(name = "invoice_seq_gen", initialValue = 10000, sequenceName = "invoice_seq")
	private long invoiceId;
	@Column(length = 10)
	private double adminDiscount;
	@Column(length = 10)
	private double finalAmount;
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	public Invoice() {
		super();
	}
	
	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public double getAdminDiscount() {
		return adminDiscount;
	}

	public void setAdminDiscount(double adminDiscount) {
		this.adminDiscount = adminDiscount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", adminDiscount=" + adminDiscount + ", finalAmount=" + finalAmount
				+ "]";
	}

	public Invoice(long invoiceId, double adminDiscount, double finalAmount, Customer customer) {
		super();
		this.invoiceId = invoiceId;
		this.adminDiscount = adminDiscount;
		this.finalAmount = finalAmount;
		this.customer = customer;
	}

}