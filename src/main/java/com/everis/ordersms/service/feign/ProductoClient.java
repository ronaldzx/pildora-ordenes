package com.everis.ordersms.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.GetMapping;

import com.everis.ordersms.dto.feign.ProductDto;

@FeignClient(name = "product-ms", url = "http://localhost:8082/products")
public interface ProductoClient {

	@GetMapping(value = "/product/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<ProductDto> getList();
}
