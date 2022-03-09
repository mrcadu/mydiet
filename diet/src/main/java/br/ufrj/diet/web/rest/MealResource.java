package br.ufrj.diet.web.rest;

import br.ufrj.diet.repository.MealRepository;
import br.ufrj.diet.service.MealService;
import br.ufrj.diet.service.dto.MealDTO;
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
 * REST controller for managing {@link br.ufrj.diet.domain.Meal}.
 */
@RestController
@RequestMapping("/api")
public class MealResource {

    private final Logger log = LoggerFactory.getLogger(MealResource.class);

    private final MealService mealService;

    private final MealRepository mealRepository;

    public MealResource(MealService mealService, MealRepository mealRepository) {
        this.mealService = mealService;
        this.mealRepository = mealRepository;
    }

    /**
     * {@code GET  /meals} : get all the meals.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of meals in body.
     */
    @GetMapping("/meals")
    public List<MealDTO> getAllMeals() {
        log.debug("REST request to get all Meals");
        return mealService.findAll();
    }

    /**
     * {@code GET  /meals/:id} : get the "id" meal.
     *
     * @param id the id of the mealDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mealDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meals/{id}")
    public ResponseEntity<MealDTO> getMeal(@PathVariable Long id) {
        log.debug("REST request to get Meal : {}", id);
        Optional<MealDTO> mealDTO = mealService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mealDTO);
    }
}
