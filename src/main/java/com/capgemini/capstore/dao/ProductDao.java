package com.capgemini.capstore.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
