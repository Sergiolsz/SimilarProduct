package com.similarproducts.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.similarproducts.client.dto.ExistingProductDTO;
import com.similarproducts.client.service.ExistingProductsClient;
import com.similarproducts.dto.SimilarProductsDTO;
import com.similarproducts.exception.SimilarProductsException;

@Service
public class SimilarProductsServiceImpl implements SimilarProductsService {

	@Autowired
	private ExistingProductsClient existingProductsClient;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public SimilarProductsDTO getSimilarProductDetail(String productId) throws SimilarProductsException {

		// Obtenemos el Producto Similar solicitado por su ID facilitado
		ExistingProductDTO existingProduct = new ExistingProductDTO();
		
		try {
			existingProduct = existingProductsClient.getExistingProductDetail(productId)
					.orElseThrow(() -> new SimilarProductsException(String.format("A similar product with this code {0} has not been found.", productId)));
		} catch (SimilarProductsException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
		
		// Mapeamos a DTO propio los datos del Producto solicitado a la API de Productos Similares
		// Se hace este Mapeo por si se requiere a nivel propio personalizar la muestra de datos del Producto
		SimilarProductsDTO similarProduct = modelMapper.map(existingProduct, SimilarProductsDTO.class);

		return similarProduct;
	}

	@Override
	public List<Integer> getSimilarProductsIds(String productId) throws SimilarProductsException {

		List<Integer> listSimilarProductsIds = new ArrayList<Integer>();
		
		try {
			// Llamada Feign para obtener el listado de ids de Productos Similares disponibles
			listSimilarProductsIds = existingProductsClient.getExistingProductsIds(productId)
					.orElseThrow(() -> new SimilarProductsException(String.format("No similar products have been found with this code {0}", productId)));
		} catch (SimilarProductsException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}

		return listSimilarProductsIds;
	}

}
