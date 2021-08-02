package com.similarproducts.client.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class ExistingProductDTO implements Serializable {
	
	private static final long serialVersionUID = -3535056263897989671L;
	
    private String id;
    private String name;
    private Double price;
    private Boolean availability;

}
