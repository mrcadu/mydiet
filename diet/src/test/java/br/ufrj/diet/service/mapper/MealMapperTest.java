package br.ufrj.diet.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MealMapperTest {

    private MealMapper mealMapper;

    @BeforeEach
    public void setUp() {
        mealMapper = new MealMapperImpl();
    }
}
