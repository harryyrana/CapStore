package com.capgemini.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
