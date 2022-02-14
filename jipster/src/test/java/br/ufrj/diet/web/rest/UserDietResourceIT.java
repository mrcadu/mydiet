package br.ufrj.diet.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.ufrj.diet.IntegrationTest;
import br.ufrj.diet.domain.UserDiet;
import br.ufrj.diet.repository.UserDietRepository;
import br.ufrj.diet.service.dto.UserDietDTO;
import br.ufrj.diet.service.mapper.UserDietMapper;
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
 * Integration tests for the {@link UserDietResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UserDietResourceIT {

    private static final String DEFAULT_USERNAME = "AAAAAAAAAA";
    private static final String UPDATED_USERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final Integer DEFAULT_AGE = 1;
    private static final Integer UPDATED_AGE = 2;

    private static final String DEFAULT_GENRE = "AAAAAAAAAA";
    private static final String UPDATED_GENRE = "BBBBBBBBBB";

    private static final String DEFAULT_BIOTYPE = "AAAAAAAAAA";
    private static final String UPDATED_BIOTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_GOAL = "AAAAAAAAAA";
    private static final String UPDATED_GOAL = "BBBBBBBBBB";

    private static final Integer DEFAULT_WEIGHT = 1;
    private static final Integer UPDATED_WEIGHT = 2;

    private static final Integer DEFAULT_HEIGHT = 1;
    private static final Integer UPDATED_HEIGHT = 2;

    private static final Integer DEFAULT_NECK = 1;
    private static final Integer UPDATED_NECK = 2;

    private static final Integer DEFAULT_WAIST = 1;
    private static final Integer UPDATED_WAIST = 2;

    private static final Integer DEFAULT_HIP = 1;
    private static final Integer UPDATED_HIP = 2;

    private static final Integer DEFAULT_BODY_FAT = 1;
    private static final Integer UPDATED_BODY_FAT = 2;

    private static final String ENTITY_API_URL = "/api/user-diets";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private UserDietRepository userDietRepository;

    @Autowired
    private UserDietMapper userDietMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUserDietMockMvc;

    private UserDiet userDiet;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserDiet createEntity(EntityManager em) {
        UserDiet userDiet = new UserDiet()
            .username(DEFAULT_USERNAME)
            .password(DEFAULT_PASSWORD)
            .age(DEFAULT_AGE)
            .genre(DEFAULT_GENRE)
            .biotype(DEFAULT_BIOTYPE)
            .goal(DEFAULT_GOAL)
            .weight(DEFAULT_WEIGHT)
            .height(DEFAULT_HEIGHT)
            .neck(DEFAULT_NECK)
            .waist(DEFAULT_WAIST)
            .hip(DEFAULT_HIP)
            .bodyFat(DEFAULT_BODY_FAT);
        return userDiet;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserDiet createUpdatedEntity(EntityManager em) {
        UserDiet userDiet = new UserDiet()
            .username(UPDATED_USERNAME)
            .password(UPDATED_PASSWORD)
            .age(UPDATED_AGE)
            .genre(UPDATED_GENRE)
            .biotype(UPDATED_BIOTYPE)
            .goal(UPDATED_GOAL)
            .weight(UPDATED_WEIGHT)
            .height(UPDATED_HEIGHT)
            .neck(UPDATED_NECK)
            .waist(UPDATED_WAIST)
            .hip(UPDATED_HIP)
            .bodyFat(UPDATED_BODY_FAT);
        return userDiet;
    }

    @BeforeEach
    public void initTest() {
        userDiet = createEntity(em);
    }

    @Test
    @Transactional
    void getAllUserDiets() throws Exception {
        // Initialize the database
        userDietRepository.saveAndFlush(userDiet);

        // Get all the userDietList
        restUserDietMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(userDiet.getId().intValue())))
            .andExpect(jsonPath("$.[*].username").value(hasItem(DEFAULT_USERNAME)))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].genre").value(hasItem(DEFAULT_GENRE)))
            .andExpect(jsonPath("$.[*].biotype").value(hasItem(DEFAULT_BIOTYPE)))
            .andExpect(jsonPath("$.[*].goal").value(hasItem(DEFAULT_GOAL)))
            .andExpect(jsonPath("$.[*].weight").value(hasItem(DEFAULT_WEIGHT)))
            .andExpect(jsonPath("$.[*].height").value(hasItem(DEFAULT_HEIGHT)))
            .andExpect(jsonPath("$.[*].neck").value(hasItem(DEFAULT_NECK)))
            .andExpect(jsonPath("$.[*].waist").value(hasItem(DEFAULT_WAIST)))
            .andExpect(jsonPath("$.[*].hip").value(hasItem(DEFAULT_HIP)))
            .andExpect(jsonPath("$.[*].bodyFat").value(hasItem(DEFAULT_BODY_FAT)));
    }

    @Test
    @Transactional
    void getUserDiet() throws Exception {
        // Initialize the database
        userDietRepository.saveAndFlush(userDiet);

        // Get the userDiet
        restUserDietMockMvc
            .perform(get(ENTITY_API_URL_ID, userDiet.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(userDiet.getId().intValue()))
            .andExpect(jsonPath("$.username").value(DEFAULT_USERNAME))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE))
            .andExpect(jsonPath("$.genre").value(DEFAULT_GENRE))
            .andExpect(jsonPath("$.biotype").value(DEFAULT_BIOTYPE))
            .andExpect(jsonPath("$.goal").value(DEFAULT_GOAL))
            .andExpect(jsonPath("$.weight").value(DEFAULT_WEIGHT))
            .andExpect(jsonPath("$.height").value(DEFAULT_HEIGHT))
            .andExpect(jsonPath("$.neck").value(DEFAULT_NECK))
            .andExpect(jsonPath("$.waist").value(DEFAULT_WAIST))
            .andExpect(jsonPath("$.hip").value(DEFAULT_HIP))
            .andExpect(jsonPath("$.bodyFat").value(DEFAULT_BODY_FAT));
    }

    @Test
    @Transactional
    void getNonExistingUserDiet() throws Exception {
        // Get the userDiet
        restUserDietMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
