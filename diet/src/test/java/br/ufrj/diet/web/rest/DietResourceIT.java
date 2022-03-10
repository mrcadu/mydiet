package br.ufrj.diet.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.ufrj.diet.IntegrationTest;
import br.ufrj.diet.domain.Diet;
import br.ufrj.diet.repository.DietRepository;
import br.ufrj.diet.service.dto.DietDTO;
import br.ufrj.diet.service.mapper.DietMapper;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link DietResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DietResourceIT {

    private static final Float DEFAULT_BASAL_METABOLIC_RATE = 1F;
    private static final Float UPDATED_BASAL_METABOLIC_RATE = 2F;

    private static final Float DEFAULT_CALORIES_GOAL = 1F;
    private static final Float UPDATED_CALORIES_GOAL = 2F;

    private static final Float DEFAULT_PROTEIN = 1F;
    private static final Float UPDATED_PROTEIN = 2F;

    private static final Float DEFAULT_CARBOHYDRATE = 1F;
    private static final Float UPDATED_CARBOHYDRATE = 2F;

    private static final Float DEFAULT_FAT = 1F;
    private static final Float UPDATED_FAT = 2F;

    private static final String ENTITY_API_URL = "/api/diets";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private DietMapper dietMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDietMockMvc;

    private Diet diet;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Diet createEntity(EntityManager em) {
        Diet diet = new Diet()
            .basalMetabolicRate(DEFAULT_BASAL_METABOLIC_RATE)
            .caloriesGoal(DEFAULT_CALORIES_GOAL)
            .protein(DEFAULT_PROTEIN)
            .carbohydrate(DEFAULT_CARBOHYDRATE)
            .fat(DEFAULT_FAT);
        return diet;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Diet createUpdatedEntity(EntityManager em) {
        Diet diet = new Diet()
            .basalMetabolicRate(UPDATED_BASAL_METABOLIC_RATE)
            .caloriesGoal(UPDATED_CALORIES_GOAL)
            .protein(UPDATED_PROTEIN)
            .carbohydrate(UPDATED_CARBOHYDRATE)
            .fat(UPDATED_FAT);
        return diet;
    }

    @BeforeEach
    public void initTest() {
        diet = createEntity(em);
    }

    @Test
    @Transactional
    void getAllDiets() throws Exception {
        // Initialize the database
        dietRepository.saveAndFlush(diet);

        // Get all the dietList
        restDietMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(diet.getId().intValue())))
            .andExpect(jsonPath("$.[*].basalMetabolicRate").value(hasItem(DEFAULT_BASAL_METABOLIC_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].caloriesGoal").value(hasItem(DEFAULT_CALORIES_GOAL.doubleValue())))
            .andExpect(jsonPath("$.[*].protein").value(hasItem(DEFAULT_PROTEIN.doubleValue())))
            .andExpect(jsonPath("$.[*].carbohydrate").value(hasItem(DEFAULT_CARBOHYDRATE.doubleValue())))
            .andExpect(jsonPath("$.[*].fat").value(hasItem(DEFAULT_FAT.doubleValue())));
    }

    @Test
    @Transactional
    void getDiet() throws Exception {
        // Initialize the database
        dietRepository.saveAndFlush(diet);

        // Get the diet
        restDietMockMvc
            .perform(get(ENTITY_API_URL_ID, diet.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(diet.getId().intValue()))
            .andExpect(jsonPath("$.basalMetabolicRate").value(DEFAULT_BASAL_METABOLIC_RATE.doubleValue()))
            .andExpect(jsonPath("$.caloriesGoal").value(DEFAULT_CALORIES_GOAL.doubleValue()))
            .andExpect(jsonPath("$.protein").value(DEFAULT_PROTEIN.doubleValue()))
            .andExpect(jsonPath("$.carbohydrate").value(DEFAULT_CARBOHYDRATE.doubleValue()))
            .andExpect(jsonPath("$.fat").value(DEFAULT_FAT.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingDiet() throws Exception {
        // Get the diet
        restDietMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
