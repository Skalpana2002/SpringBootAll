package com.jsp.ShoppingCart.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ShoppingCart.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	public List<Product> getByProductName(String name);

}
