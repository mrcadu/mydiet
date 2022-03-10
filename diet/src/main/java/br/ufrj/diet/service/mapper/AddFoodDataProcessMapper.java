package br.ufrj.diet.service.mapper;

import br.ufrj.diet.domain.*;
import br.ufrj.diet.service.dto.AddFoodDataProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AddFoodDataProcess} and its DTO {@link AddFoodDataProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, FoodMapper.class })
public interface AddFoodDataProcessMapper extends EntityMapper<AddFoodDataProcessDTO, AddFoodDataProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "food", source = "food")
    AddFoodDataProcessDTO toDto(AddFoodDataProcess s);
}
