package br.ufrj.diet.web.rest;

import br.ufrj.diet.repository.FoodRepository;
import br.ufrj.diet.service.FoodService;
import br.ufrj.diet.service.dto.FoodDTO;
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
 * REST controller for managing {@link br.ufrj.diet.domain.Food}.
 */
@RestController
@RequestMapping("/api")
public class FoodResource {

    private final Logger log = LoggerFactory.getLogger(FoodResource.class);

    private final FoodService foodService;

    private final FoodRepository foodRepository;

    public FoodResource(FoodService foodService, FoodRepository foodRepository) {
        this.foodService = foodService;
        this.foodRepository = foodRepository;
    }

    /**
     * {@code GET  /foods} : get all the foods.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of foods in body.
     */
    @GetMapping("/foods")
    public List<FoodDTO> getAllFoods() {
        log.debug("REST request to get all Foods");
        return foodService.findAll();
    }

    /**
     * {@code GET  /foods/:id} : get the "id" food.
     *
     * @param id the id of the foodDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the foodDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/foods/{id}")
    public ResponseEntity<FoodDTO> getFood(@PathVariable Long id) {
        log.debug("REST request to get Food : {}", id);
        Optional<FoodDTO> foodDTO = foodService.findOne(id);
        return ResponseUtil.wrapOrNotFound(foodDTO);
    }
}
