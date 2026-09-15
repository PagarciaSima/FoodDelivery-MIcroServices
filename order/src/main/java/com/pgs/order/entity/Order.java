package com.pgs.order.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pgs.order.dto.FoodItemsDTO;
import com.pgs.order.dto.Restaurant;
import com.pgs.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    @Id
    private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private Restaurant restaurant; 
    private UserDTO userDTO;       
}