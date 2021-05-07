package com.everis.ordersms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.ordersms.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
