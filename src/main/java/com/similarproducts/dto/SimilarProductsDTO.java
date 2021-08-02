package com.similarproducts.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Similar Product")
public class SimilarProductsDTO implements Serializable {

	private static final long serialVersionUID = -4358623211903444415L;
	
	private String id;
    private String name;
    private Double price;
    private Boolean availability;
}
