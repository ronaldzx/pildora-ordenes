package com.everis.ordersms.service;

import com.everis.ordersms.dto.SaveOrderRequestDto;
import com.everis.ordersms.dto.SaveOrderResponseDto;

public interface OrdenService {
	
	SaveOrderResponseDto saveOrder(SaveOrderRequestDto request) throws Exception;
	
}
