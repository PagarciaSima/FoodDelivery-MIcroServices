package com.pgs.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pgs.order.dto.OrderDTO;
import com.pgs.order.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

}
