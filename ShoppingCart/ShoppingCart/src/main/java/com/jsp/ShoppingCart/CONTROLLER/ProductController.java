package com.jsp.ShoppingCart.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ShoppingCart.DAO.ProductDao;
import com.jsp.ShoppingCart.DTO.Product;

@RestController
public class ProductController {
	@Autowired
	ProductDao dao;
	@PostMapping("/productsaved")
	public String saveProduct(@RequestBody Product product)
	{
		 String message=dao.addProduct(product);
		return message;
		
	}
	//we can give same end point(url) because method is different
	@GetMapping("/getlistofproductsfromdb")
	public List<Product>  findAllProduct()
	{
		return dao.getAllProducts();
	}
	@GetMapping("/getbyproductid")
	public Product getProductById(@RequestParam int id)
	{
		return dao.findProductById(id);
		 
		
	}
	
	@GetMapping("/getbyname")
	public List<Product> getByName(String name)
	{
		List<Product> pname=dao.getByProductName(name);
		return pname;
		
	}
	
	
	
	@DeleteMapping("/deletebyid")
	public String getDeleteById(int id)
	{
//		return dao.deleteProduct(id);
		String del=dao.deleteProduct(id);
		return del;
		
	}
	
	
	@PutMapping("/updateproduct")
	public Product updateQuantity(@RequestParam int id ,@RequestParam int quantity)
	{
		return dao.updateQuantityById(id, quantity);
		
		
   }
	
	
	
	

}
