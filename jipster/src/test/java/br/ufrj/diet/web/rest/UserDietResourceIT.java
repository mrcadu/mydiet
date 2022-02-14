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
        UserDiet userDiet = new UserDiet().username(DEFAULT_USERNAME).password(DEFAULT_PASSWORD);
        return userDiet;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserDiet createUpdatedEntity(EntityManager em) {
        UserDiet userDiet = new UserDiet().username(UPDATED_USERNAME).password(UPDATED_PASSWORD);
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
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)));
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
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD));
    }

    @Test
    @Transactional
    void getNonExistingUserDiet() throws Exception {
        // Get the userDiet
        restUserDietMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
