package br.ufrj.diet.service.mapper;

import br.ufrj.diet.domain.*;
import br.ufrj.diet.service.dto.DietDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Diet} and its DTO {@link DietDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DietMapper extends EntityMapper<DietDTO, Diet> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DietDTO toDtoId(Diet diet);
}
