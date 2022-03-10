package br.ufrj.diet.service.mapper;

import br.ufrj.diet.domain.*;
import br.ufrj.diet.service.dto.MealDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Meal} and its DTO {@link MealDTO}.
 */
@Mapper(componentModel = "spring", uses = { DietMapper.class })
public interface MealMapper extends EntityMapper<MealDTO, Meal> {
    @Mapping(target = "diet", source = "diet", qualifiedByName = "id")
    MealDTO toDto(Meal s);

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MealDTO toDtoId(Meal meal);
}
