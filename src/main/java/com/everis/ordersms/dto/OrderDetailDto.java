package com.everis.ordersms.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailDto {
	private Double price;
	private Integer productId;
	private Integer quantity;
}
