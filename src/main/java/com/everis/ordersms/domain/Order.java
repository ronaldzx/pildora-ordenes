package com.everis.ordersms.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@Setter
@Getter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "client_id")
	private Integer clientId;	
	@Column(name = "date")
	private Date date;
	@Column(name = "shipment_date")
	private Date shipmentDate;
	@Column(name = "total")
	private Double total;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
}
