package com.capgemini.capstore.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
	@SequenceGenerator(name = "order_seq_gen", initialValue = 10000, sequenceName = "order_seq")
	private long orderId;
	private double discountTotal;
	private int quantity;
	private double totalAmount;
	@OneToOne(fetch = FetchType.LAZY)
	private Invoice invoice;
	@OneToOne(fetch = FetchType.LAZY)
	private Product product;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", discountTotal=" + discountTotal + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + "]";
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getDiscountTotal() {
		return discountTotal;
	}

	public void setDiscountTotal(double discountTotal) {
		this.discountTotal = discountTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Order(long orderId, double discountTotal, int quantity, double totalAmount, Invoice invoice,
			Product product) {
		super();
		this.orderId = orderId;
		this.discountTotal = discountTotal;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.invoice = invoice;
		this.product = product;
	}

	public Order() {
		super();
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}