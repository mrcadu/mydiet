package br.ufrj.diet.service.mapper;

import br.ufrj.diet.domain.*;
import br.ufrj.diet.service.dto.UserDietDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserDiet} and its DTO {@link UserDietDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserDietMapper extends EntityMapper<UserDietDTO, UserDiet> {}
