package com.similarproducts.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.similarproducts.client.dto.ExistingProductDTO;

@Service
@FeignClient(name = "${existing-apis.name}", url = "${existing-apis.url.base}")
public interface ExistingProductsClient {

	@GetMapping("${existing-apis.url.product}")
	Optional<ExistingProductDTO> getExistingProductDetail(@PathVariable() String productId);

	@GetMapping("${existing-apis.url.similarids}")
	Optional<List<Integer>> getExistingProductsIds(@PathVariable() String productId);
}
