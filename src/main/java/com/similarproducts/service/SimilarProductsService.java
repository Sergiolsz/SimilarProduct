package com.similarproducts.service;

import java.util.List;

import com.similarproducts.dto.SimilarProductsDTO;
import com.similarproducts.exception.SimilarProductsException;

public interface SimilarProductsService {

	SimilarProductsDTO getSimilarProductDetail(String productId) throws SimilarProductsException;
	
	List<Integer> getSimilarProductsIds(String productId) throws SimilarProductsException;
}
