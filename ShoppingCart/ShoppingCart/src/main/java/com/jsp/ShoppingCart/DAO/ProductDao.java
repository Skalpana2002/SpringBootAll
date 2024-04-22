
package com.jsp.ShoppingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.ShoppingCart.DTO.Product;
import com.jsp.ShoppingCart.REPOSITORY.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository repositoty ;
	// to insert  object into database
	public String addProduct(Product product)
	{
		repositoty.save(product);
		return "product added to cart successfully";
				
		
	}
	 
	// to fetch all objects from database
	
	public List<Product> getAllProducts()
	{
		return repositoty.findAll();
	}
	
	
	
	//to fetch one object based on id
	public Product findProductById(int id)
	{
		Optional<Product> opt =repositoty.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
		
    }
	
	
	
	//to fetch one object based on name
	
	@GetMapping("/getbyproductname")
	public List<Product> getByProductName(String name)
	{
		return repositoty.getByProductName(name);
		
	}
	
	
	
	
	
	// to delete an object from the database
	 public  String deleteProduct(int id)
	 {
		 
		Product p =findProductById(id);
		if(p!=null)
		{
			String productName=p.getProductName();
			repositoty.delete(p); //// we can use repositoty.deleteById(p);
			return productName+"  "+"Product Removed From Cart";
		}
     	return "Product Not Available In The Cart";
		 
	 }
	 
	 
	 
	 
	 
	// update the quantity of a product based on id
		public Product updateQuantityById(int id , int newQuantity)
		{
			Product p=findProductById(id);
			if(p!=null)
			{
				p.setQuantity(newQuantity);
				repositoty.save(p);
				return p;
				
			}
			return null;
			
		}

}
