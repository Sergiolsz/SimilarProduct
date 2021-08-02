package com.similarproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.similarproducts.dto.SimilarProductsDTO;
import com.similarproducts.exception.SimilarProductsException;
import com.similarproducts.service.SimilarProductsServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Similar Product Microservice")
@RestController
@RequestMapping("/product")
public class SimilarProductsController {

	@Autowired
	private SimilarProductsServiceImpl productService;
	
	@ApiOperation(value = "Gets a product detail", notes = "Returns the product detail for a given productId" )
	@ResponseBody
	@GetMapping("/{productId}")
	public SimilarProductsDTO getSimilarProductDetail(@PathVariable("productId") String productId) throws SimilarProductsException {
		return productService.getSimilarProductDetail(productId);
	}

	@ApiOperation(value = "Gets the ids of the similar products", notes = "Returns the similar products to a given one ordered by similarity")
	@ResponseBody
	@GetMapping("/{productId}/similar")
	public List<Integer> getSimilarProductsIds(@PathVariable("productId") String productId) throws SimilarProductsException {
		return productService.getSimilarProductsIds(productId);
	}
	
}
