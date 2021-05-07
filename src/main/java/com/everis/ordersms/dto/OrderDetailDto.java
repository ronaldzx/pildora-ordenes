package com.everis.ordersms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDetailDto {
	private Double price;
	private Integer productId;
	private Integer quantity;
}
