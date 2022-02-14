package br.ufrj.diet.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.ufrj.diet.IntegrationTest;
import br.ufrj.diet.domain.Food;
import br.ufrj.diet.repository.FoodRepository;
import br.ufrj.diet.service.dto.FoodDTO;
import br.ufrj.diet.service.mapper.FoodMapper;
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
 * Integration tests for the {@link FoodResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FoodResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Float DEFAULT_GRAMS = 1F;
    private static final Float UPDATED_GRAMS = 2F;

    private static final Float DEFAULT_PROTEIN = 1F;
    private static final Float UPDATED_PROTEIN = 2F;

    private static final Float DEFAULT_CARBOHYDRATE = 1F;
    private static final Float UPDATED_CARBOHYDRATE = 2F;

    private static final Float DEFAULT_FAT = 1F;
    private static final Float UPDATED_FAT = 2F;

    private static final Float DEFAULT_CALORIES = 1F;
    private static final Float UPDATED_CALORIES = 2F;

    private static final String ENTITY_API_URL = "/api/foods";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFoodMockMvc;

    private Food food;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Food createEntity(EntityManager em) {
        Food food = new Food()
            .name(DEFAULT_NAME)
            .grams(DEFAULT_GRAMS)
            .protein(DEFAULT_PROTEIN)
            .carbohydrate(DEFAULT_CARBOHYDRATE)
            .fat(DEFAULT_FAT)
            .calories(DEFAULT_CALORIES);
        return food;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Food createUpdatedEntity(EntityManager em) {
        Food food = new Food()
            .name(UPDATED_NAME)
            .grams(UPDATED_GRAMS)
            .protein(UPDATED_PROTEIN)
            .carbohydrate(UPDATED_CARBOHYDRATE)
            .fat(UPDATED_FAT)
            .calories(UPDATED_CALORIES);
        return food;
    }

    @BeforeEach
    public void initTest() {
        food = createEntity(em);
    }

    @Test
    @Transactional
    void getAllFoods() throws Exception {
        // Initialize the database
        foodRepository.saveAndFlush(food);

        // Get all the foodList
        restFoodMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(food.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].grams").value(hasItem(DEFAULT_GRAMS.doubleValue())))
            .andExpect(jsonPath("$.[*].protein").value(hasItem(DEFAULT_PROTEIN.doubleValue())))
            .andExpect(jsonPath("$.[*].carbohydrate").value(hasItem(DEFAULT_CARBOHYDRATE.doubleValue())))
            .andExpect(jsonPath("$.[*].fat").value(hasItem(DEFAULT_FAT.doubleValue())))
            .andExpect(jsonPath("$.[*].calories").value(hasItem(DEFAULT_CALORIES.doubleValue())));
    }

    @Test
    @Transactional
    void getFood() throws Exception {
        // Initialize the database
        foodRepository.saveAndFlush(food);

        // Get the food
        restFoodMockMvc
            .perform(get(ENTITY_API_URL_ID, food.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(food.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.grams").value(DEFAULT_GRAMS.doubleValue()))
            .andExpect(jsonPath("$.protein").value(DEFAULT_PROTEIN.doubleValue()))
            .andExpect(jsonPath("$.carbohydrate").value(DEFAULT_CARBOHYDRATE.doubleValue()))
            .andExpect(jsonPath("$.fat").value(DEFAULT_FAT.doubleValue()))
            .andExpect(jsonPath("$.calories").value(DEFAULT_CALORIES.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingFood() throws Exception {
        // Get the food
        restFoodMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
