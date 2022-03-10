package br.ufrj.diet.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDietMapperTest {

    private UserDietMapper userDietMapper;

    @BeforeEach
    public void setUp() {
        userDietMapper = new UserDietMapperImpl();
    }
}
