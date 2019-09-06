package com.capgemini.capstore.beans;

import java.sql.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.capgemini.capstore.util.OrderStatus;

public class DeliveryStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "del_seq_gen")
	@SequenceGenerator(name = "del_seq_gen", initialValue = 10000, sequenceName = "del_seq") // to be created
	private long id;
	private OrderStatus status;
	@OneToOne(fetch = FetchType.LAZY)
	private Order order;
	private Date deliveryDate;

	@Override
	public String toString() {
		return "DeliveryStatus [id=" + id + ", status=" + status + ", order=" + order.getOrderId() + ", deliveryDate="
				+ deliveryDate + "]";
	}

	public DeliveryStatus() {
		super();
	}

	public DeliveryStatus(long id, OrderStatus status, Order order, Date deliveryDate) {
		super();
		this.id = id;
		this.status = status;
		this.order = order;
		this.deliveryDate = deliveryDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
