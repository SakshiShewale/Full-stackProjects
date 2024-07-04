package com.cjc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjc.Repository.ProductRepository;

import com.cjc.model.Product;

public class ServiceIMPL implements ProductService {

	
@Autowired	
private ProductRepository proRepo;
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return proRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
	 return proRepo.save(product);
	}

	@Override
	public Product deleteProduct(int Product_Id) {
		// TODO Auto-generated method stub
		
		Product product = proRepo.findById(Product_Id).get();
		proRepo.deleteById(Product_Id);
		return product;
	}

}
