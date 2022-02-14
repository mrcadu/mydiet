package br.ufrj.diet.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import br.ufrj.diet.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserDietDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserDietDTO.class);
        UserDietDTO userDietDTO1 = new UserDietDTO();
        userDietDTO1.setId(1L);
        UserDietDTO userDietDTO2 = new UserDietDTO();
        assertThat(userDietDTO1).isNotEqualTo(userDietDTO2);
        userDietDTO2.setId(userDietDTO1.getId());
        assertThat(userDietDTO1).isEqualTo(userDietDTO2);
        userDietDTO2.setId(2L);
        assertThat(userDietDTO1).isNotEqualTo(userDietDTO2);
        userDietDTO1.setId(null);
        assertThat(userDietDTO1).isNotEqualTo(userDietDTO2);
    }
}
