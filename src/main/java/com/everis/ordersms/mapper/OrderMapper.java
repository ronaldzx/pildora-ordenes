package com.everis.ordersms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.everis.ordersms.domain.Order;
import com.everis.ordersms.domain.OrderDetail;
import com.everis.ordersms.dto.OrderDetailDto;
import com.everis.ordersms.dto.SaveOrderRequestDto;
import com.everis.ordersms.dto.SaveOrderResponseDto;
import com.everis.ordersms.service.impl.util.OrderUtils;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	@Mapping(target = "orderDetails", source = "orderDetail")
	Order saveOrderRequestDtoToOrder(SaveOrderRequestDto saveOrderRequestDto);
	
	OrderDetailDto orderDetailToOrderDetailDto(OrderDetail orderDetail);
	
	List<OrderDetailDto> orderDetailToOrderDetailDto(List<OrderDetail> orderDetail);
	
	SaveOrderResponseDto orderToSaveOrderResponseDto(Order orden);
	
	@AfterMapping
	default void setRemainingValues(SaveOrderRequestDto saveOrderRequestDto, @MappingTarget Order order) {
		Double total = 0d;
		
		List<OrderDetail> detalles = new ArrayList<>();

		for(OrderDetailDto ordenDetalle : saveOrderRequestDto.getOrderDetail()) {
			
			OrderDetail ordendetalle = new OrderDetail();
			
			ordendetalle.setPrice(ordenDetalle.getPrice());
			ordendetalle.setProductId(ordenDetalle.getProductId());
			ordendetalle.setQuantity(ordenDetalle.getQuantity());
			
			total += ordenDetalle.getPrice() * ordenDetalle.getQuantity();
			
			detalles.add(ordendetalle);
		}
		
		Double totalIgv = total * OrderUtils.IGV;
		
		order.setActive(Boolean.TRUE);
		order.setTotal(total + totalIgv);
		order.setOrderDetails(detalles);
		
		for(OrderDetail detalle: detalles) {
			detalle.setOrder(order);
		}
		
	}
}
