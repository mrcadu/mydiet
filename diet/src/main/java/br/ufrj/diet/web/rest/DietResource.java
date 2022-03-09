package br.ufrj.diet.web.rest;

import br.ufrj.diet.repository.DietRepository;
import br.ufrj.diet.service.DietService;
import br.ufrj.diet.service.dto.DietDTO;
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
 * REST controller for managing {@link br.ufrj.diet.domain.Diet}.
 */
@RestController
@RequestMapping("/api")
public class DietResource {

    private final Logger log = LoggerFactory.getLogger(DietResource.class);

    private final DietService dietService;

    private final DietRepository dietRepository;

    public DietResource(DietService dietService, DietRepository dietRepository) {
        this.dietService = dietService;
        this.dietRepository = dietRepository;
    }

    /**
     * {@code GET  /diets} : get all the diets.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of diets in body.
     */
    @GetMapping("/diets")
    public List<DietDTO> getAllDiets() {
        log.debug("REST request to get all Diets");
        return dietService.findAll();
    }

    /**
     * {@code GET  /diets/:id} : get the "id" diet.
     *
     * @param id the id of the dietDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dietDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/diets/{id}")
    public ResponseEntity<DietDTO> getDiet(@PathVariable Long id) {
        log.debug("REST request to get Diet : {}", id);
        Optional<DietDTO> dietDTO = dietService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dietDTO);
    }
}
