package com.capgemini.capstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capstore_category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq_gen")
	@SequenceGenerator(name = "cat_seq_gen", initialValue = 1, sequenceName = "cat_seq")
	private long categoryId;
	@Column(length = 20)
	private String categoryGender;
	@Column(length = 20)
	private String categoryType;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryGender() {
		return categoryGender;
	}

	public void setCategoryGender(String categoryGender) {
		this.categoryGender = categoryGender;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Category() {
		super();
	}

	public Category(long categoryId, String categoryGender, String categoryType) {
		super();
		this.categoryId = categoryId;
		this.categoryGender = categoryGender;
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "CategoryMaster [categoryId=" + categoryId + ", categoryGender=" + categoryGender + ", categoryType="
				+ categoryType + "]";
	}

}