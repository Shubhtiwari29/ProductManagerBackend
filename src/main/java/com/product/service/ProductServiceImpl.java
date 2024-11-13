package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;	
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepository.findById(id).get();
		if(product!= null)
		{
		productRepository.delete(product);
		return "Product deleted..";
		}
		return "Somthing went Wrong..";
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
		Product oldproduct = productRepository.findById(id).get();
		oldproduct.setProductName(product.getProductName());
		oldproduct.setDescription(product.getDescription());	
		oldproduct.setPrice(product.getPrice());
		oldproduct.setStatus(product.getStatus());
		return productRepository.save(oldproduct);
	}

}
