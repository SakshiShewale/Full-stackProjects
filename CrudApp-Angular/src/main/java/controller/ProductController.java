package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cjc.Service.ProductService;
import com.cjc.model.Product;

@RestController
@RequestMapping("/product-service")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//@RequestMapping(value="/",method=RequestMethod.POST)
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
	
	 return productService.saveProduct(product);
	  
	}
	
	
	@GetMapping("/")
	public List<Product> getAllStudent()
	{
		return productService.getAllProduct();
		
	}

	@DeleteMapping("/{product_ID}")
	public Product deleteProduct(@PathVariable int product_ID)
	{
		return productService.deleteProduct(product_ID);
	}

	@PutMapping("/")
	public Product UpdateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}

}
