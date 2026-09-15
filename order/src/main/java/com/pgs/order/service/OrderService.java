package com.pgs.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pgs.order.dto.OrderDTO;
import com.pgs.order.dto.OrderDTOFromFE;
import com.pgs.order.dto.UserDTO;
import com.pgs.order.entity.Order;
import com.pgs.order.mapper.OrderMapper;
import com.pgs.order.repository.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SequenceGenerator sequenceGenerator;

    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
	}

}