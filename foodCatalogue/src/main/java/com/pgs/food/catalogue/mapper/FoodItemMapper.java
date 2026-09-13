package com.pgs.food.catalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pgs.food.catalogue.dto.FoodItemDTO;
import com.pgs.food.catalogue.entity.FoodItem;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);

}