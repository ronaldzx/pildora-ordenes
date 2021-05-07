package com.everis.ordersms.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.everis.ordersms.domain.Order;
import com.everis.ordersms.dto.SaveOrderRequestDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	@Mapping(target = "orderDetails", source = "orderDetail")
	Order saveOrderRequestDtoToOrder(SaveOrderRequestDto saveOrderRequestDto);
	
	
	@AfterMapping
	default void setRemainingValues(SaveOrderRequestDto saveOrderRequestDto, @MappingTarget Order order) {
		Order result = new Order();
		if(saveOrderRequestDto.getClientId() == 1) {
			result.setActive(Boolean.TRUE);
		}
	}
}
