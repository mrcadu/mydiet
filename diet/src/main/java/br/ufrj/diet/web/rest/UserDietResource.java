package br.ufrj.diet.web.rest;

import br.ufrj.diet.repository.UserDietRepository;
import br.ufrj.diet.service.UserDietService;
import br.ufrj.diet.service.dto.UserDietDTO;
import br.ufrj.diet.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link br.ufrj.diet.domain.UserDiet}.
 */
@RestController
@RequestMapping("/api")
public class UserDietResource {

    private final Logger log = LoggerFactory.getLogger(UserDietResource.class);

    private final UserDietService userDietService;

    private final UserDietRepository userDietRepository;

    public UserDietResource(UserDietService userDietService, UserDietRepository userDietRepository) {
        this.userDietService = userDietService;
        this.userDietRepository = userDietRepository;
    }

    /**
     * {@code GET  /user-diets} : get all the userDiets.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userDiets in body.
     */
    @GetMapping("/user-diets")
    public List<UserDietDTO> getAllUserDiets() {
        log.debug("REST request to get all UserDiets");
        return userDietService.findAll();
    }

    /**
     * {@code GET  /user-diets/:id} : get the "id" userDiet.
     *
     * @param id the id of the userDietDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userDietDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-diets/{id}")
    public ResponseEntity<UserDietDTO> getUserDiet(@PathVariable Long id) {
        log.debug("REST request to get UserDiet : {}", id);
        Optional<UserDietDTO> userDietDTO = userDietService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userDietDTO);
    }
}
