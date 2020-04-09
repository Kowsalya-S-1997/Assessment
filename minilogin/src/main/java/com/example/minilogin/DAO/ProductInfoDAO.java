package com.example.minilogin.DAO;

import java.util.List;

import com.example.minilogin.model.ProductInfo;

public interface ProductInfoDAO {
	public List<ProductInfo> viewAllProducts();
	/* public List<ProductInfo> getProd(); */
	
	public List<ProductInfo> viewAllProducts1(String id);
}