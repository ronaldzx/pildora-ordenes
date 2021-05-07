package com.everis.ordersms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.ordersms.dto.SaveOrderRequestDto;
import com.everis.ordersms.dto.SaveOrderResponseDto;
import com.everis.ordersms.service.OrdenService;

@RestController
public class OrderController {

	@Autowired
	private OrdenService ordenService;
	
	@PostMapping("/order/save")
	SaveOrderResponseDto saveOrden(@RequestBody @Valid SaveOrderRequestDto request ) throws Exception {
		
		return ordenService.saveOrder(request);
	}
	
	
}
