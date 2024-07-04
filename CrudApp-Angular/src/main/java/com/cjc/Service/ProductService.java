package com.cjc.Service;

import java.util.List;

import com.cjc.model.Product;


public interface ProductService {
 
	//create new record
	Product saveProduct(Product product);
   
	//fetch the record
	 List<Product>getAllProduct();
  
     Product updateProduct(Product product);
  
     Product deleteProduct(int Product_Id); 
}
