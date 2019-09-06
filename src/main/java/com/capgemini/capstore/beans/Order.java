package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@ManyToOne(fetch = FetchType.LAZY)
	private Invoice invoice;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Product> products;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", discountTotal=" + discountTotal + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + ", invoice=" + invoice + "]";
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

	public Order(long orderId, double discountTotal, int quantity, double totalAmount,
			Invoice invoice, List<Product> products) {
		super();
		this.orderId = orderId;
		this.discountTotal = discountTotal;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.invoice = invoice;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}