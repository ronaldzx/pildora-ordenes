package com.everis.ordersms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.ordersms.domain.Order;
import com.everis.ordersms.dto.OrderDetailDto;
import com.everis.ordersms.dto.SaveOrderRequestDto;
import com.everis.ordersms.dto.SaveOrderResponseDto;
import com.everis.ordersms.dto.feign.ProductDto;
import com.everis.ordersms.mapper.OrderMapper;
import com.everis.ordersms.repository.OrderRepository;
import com.everis.ordersms.service.OrdenService;
import com.everis.ordersms.service.feign.ProductoClient;

@Service
public class OrderServiceImpl implements OrdenService {

	@Autowired
	private ProductoClient productoClient;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public SaveOrderResponseDto saveOrder(SaveOrderRequestDto request) throws Exception {
		
		List<ProductDto> productos =  productoClient.getList();
		
		List<Long> idsProductos = new ArrayList<>();
		
		for(ProductDto productoDto : productos) {
			idsProductos.add(productoDto.getId());
			
		}
		
		for( OrderDetailDto ordendetalle : request.getOrderDetail()) {
				if(!idsProductos.contains(Long.valueOf(ordendetalle.getProductId()))) {
					throw new Exception(String.format("%s%s", "No se puede considerar como producto que tiene id", ordendetalle.getProductId()));
				}
		}
		
		Order ordenToSave =  orderMapper.saveOrderRequestDtoToOrder(request);
		
		Order ordenSaved = orderRepository.save(ordenToSave);
		
		SaveOrderResponseDto ordenSavedDto = orderMapper.orderToSaveOrderResponseDto(ordenSaved);
		
		return ordenSavedDto;
	}

}
