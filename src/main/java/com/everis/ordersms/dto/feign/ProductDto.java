package com.everis.ordersms.dto.feign;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductDto {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String status;
}
