package br.ufrj.diet.service;

import br.ufrj.diet.domain.UserDiet;
import br.ufrj.diet.repository.UserDietRepository;
import br.ufrj.diet.service.dto.UserDietDTO;
import br.ufrj.diet.service.mapper.UserDietMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link UserDiet}.
 */
@Service
@Transactional
public class UserDietService {

    private final Logger log = LoggerFactory.getLogger(UserDietService.class);

    private final UserDietRepository userDietRepository;

    private final UserDietMapper userDietMapper;

    public UserDietService(UserDietRepository userDietRepository, UserDietMapper userDietMapper) {
        this.userDietRepository = userDietRepository;
        this.userDietMapper = userDietMapper;
    }

    /**
     * Save a userDiet.
     *
     * @param userDietDTO the entity to save.
     * @return the persisted entity.
     */
    public UserDietDTO save(UserDietDTO userDietDTO) {
        log.debug("Request to save UserDiet : {}", userDietDTO);
        UserDiet userDiet = userDietMapper.toEntity(userDietDTO);
        userDiet = userDietRepository.save(userDiet);
        return userDietMapper.toDto(userDiet);
    }

    /**
     * Partially update a userDiet.
     *
     * @param userDietDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<UserDietDTO> partialUpdate(UserDietDTO userDietDTO) {
        log.debug("Request to partially update UserDiet : {}", userDietDTO);

        return userDietRepository
            .findById(userDietDTO.getId())
            .map(
                existingUserDiet -> {
                    userDietMapper.partialUpdate(existingUserDiet, userDietDTO);
                    return existingUserDiet;
                }
            )
            .map(userDietRepository::save)
            .map(userDietMapper::toDto);
    }

    /**
     * Get all the userDiets.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<UserDietDTO> findAll() {
        log.debug("Request to get all UserDiets");
        return userDietRepository.findAll().stream().map(userDietMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one userDiet by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserDietDTO> findOne(Long id) {
        log.debug("Request to get UserDiet : {}", id);
        return userDietRepository.findById(id).map(userDietMapper::toDto);
    }

    /**
     * Delete the userDiet by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserDiet : {}", id);
        userDietRepository.deleteById(id);
    }
}
