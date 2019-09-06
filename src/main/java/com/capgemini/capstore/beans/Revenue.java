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
@Table(name = "capstore_revenue")
public class Revenue {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revenue_seq_gen")
	@SequenceGenerator(name = "revenue_seq_gen", initialValue = 10000, sequenceName = "revenue_seq")
	private long revenueId;
	@Column(length = 20)
	private long invoiceId;
	private double previousRevenue;
	private double currentRevenue;
	private Date date;

	public Revenue(long revenueId, long invoiceId, double previousRevenue, double currentRevenue, Date date) {
		super();
		this.revenueId = revenueId;
		this.invoiceId = invoiceId;
		this.previousRevenue = previousRevenue;
		this.currentRevenue = currentRevenue;
		this.date = date;
	}

	public Revenue() {
		super();
	}

	public long getRevenueId() {
		return revenueId;
	}

	public void setRevenueId(long revenueId) {
		this.revenueId = revenueId;
	}

	public double getPreviousRevenue() {
		return previousRevenue;
	}

	public void setPreviousRevenue(double previousRevenue) {
		this.previousRevenue = previousRevenue;
	}

	public double getCurrentRevenue() {
		return currentRevenue;
	}

	public void setCurrentRevenue(double currentRevenue) {
		this.currentRevenue = currentRevenue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

}