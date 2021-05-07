package com.everis.ordersms.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveOrderResponseDto {

	private Long id;
	
	private Long clientId;
	
	private Date date;
	
	private Double total;
	
	private List<OrderDetailDto> orderDetails;
	
}
