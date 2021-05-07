package com.everis.ordersms.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveOrderRequestDto {
	private Integer clientId;
	private Date shipmentDate;
	private List<OrderDetailDto> orderDetail;
}
