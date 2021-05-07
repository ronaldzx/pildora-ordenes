package com.everis.ordersms.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SaveOrderRequestDto {
	
	@NotNull
	private Integer clientId;
	
	private Date shipmentDate;
	private List<OrderDetailDto> orderDetail;
}
