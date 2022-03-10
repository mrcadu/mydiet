package br.ufrj.diet.service.mapper;

import br.ufrj.diet.domain.*;
import br.ufrj.diet.service.dto.FoodDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Food} and its DTO {@link FoodDTO}.
 */
@Mapper(componentModel = "spring", uses = { MealMapper.class })
public interface FoodMapper extends EntityMapper<FoodDTO, Food> {
    @Mapping(target = "meal", source = "meal", qualifiedByName = "id")
    FoodDTO toDto(Food s);
}
