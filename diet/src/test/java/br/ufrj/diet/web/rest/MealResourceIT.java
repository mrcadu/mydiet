package br.ufrj.diet.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.ufrj.diet.IntegrationTest;
import br.ufrj.diet.domain.Meal;
import br.ufrj.diet.repository.MealRepository;
import br.ufrj.diet.service.dto.MealDTO;
import br.ufrj.diet.service.mapper.MealMapper;
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
 * Integration tests for the {@link MealResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class MealResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/meals";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private MealMapper mealMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMealMockMvc;

    private Meal meal;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Meal createEntity(EntityManager em) {
        Meal meal = new Meal().name(DEFAULT_NAME);
        return meal;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Meal createUpdatedEntity(EntityManager em) {
        Meal meal = new Meal().name(UPDATED_NAME);
        return meal;
    }

    @BeforeEach
    public void initTest() {
        meal = createEntity(em);
    }

    @Test
    @Transactional
    void getAllMeals() throws Exception {
        // Initialize the database
        mealRepository.saveAndFlush(meal);

        // Get all the mealList
        restMealMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(meal.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }

    @Test
    @Transactional
    void getMeal() throws Exception {
        // Initialize the database
        mealRepository.saveAndFlush(meal);

        // Get the meal
        restMealMockMvc
            .perform(get(ENTITY_API_URL_ID, meal.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(meal.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    void getNonExistingMeal() throws Exception {
        // Get the meal
        restMealMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
