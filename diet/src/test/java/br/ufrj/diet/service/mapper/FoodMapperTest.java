package br.ufrj.diet.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodMapperTest {

    private FoodMapper foodMapper;

    @BeforeEach
    public void setUp() {
        foodMapper = new FoodMapperImpl();
    }
}
