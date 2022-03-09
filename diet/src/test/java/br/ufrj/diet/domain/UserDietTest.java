package br.ufrj.diet.domain;

import static org.assertj.core.api.Assertions.assertThat;

import br.ufrj.diet.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserDietTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserDiet.class);
        UserDiet userDiet1 = new UserDiet();
        userDiet1.setId(1L);
        UserDiet userDiet2 = new UserDiet();
        userDiet2.setId(userDiet1.getId());
        assertThat(userDiet1).isEqualTo(userDiet2);
        userDiet2.setId(2L);
        assertThat(userDiet1).isNotEqualTo(userDiet2);
        userDiet1.setId(null);
        assertThat(userDiet1).isNotEqualTo(userDiet2);
    }
}
