package com.everis.ordersms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.ordersms.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
