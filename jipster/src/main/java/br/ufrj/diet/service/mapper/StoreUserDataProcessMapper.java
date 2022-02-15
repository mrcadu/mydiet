package br.ufrj.diet.service.mapper;

import br.ufrj.diet.domain.*;
import br.ufrj.diet.service.dto.StoreUserDataProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link StoreUserDataProcess} and its DTO {@link StoreUserDataProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, UserDietMapper.class })
public interface StoreUserDataProcessMapper extends EntityMapper<StoreUserDataProcessDTO, StoreUserDataProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "userDiet", source = "userDiet")
    StoreUserDataProcessDTO toDto(StoreUserDataProcess s);
}
