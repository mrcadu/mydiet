package br.ufrj.diet.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link br.ufrj.diet.domain.StoreUserDataProcess} entity.
 */
public class StoreUserDataProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private UserDietDTO userDiet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public UserDietDTO getUserDiet() {
        return userDiet;
    }

    public void setUserDiet(UserDietDTO userDiet) {
        this.userDiet = userDiet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreUserDataProcessDTO)) {
            return false;
        }

        StoreUserDataProcessDTO storeUserDataProcessDTO = (StoreUserDataProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, storeUserDataProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StoreUserDataProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", userDiet=" + getUserDiet() +
            "}";
    }
}
