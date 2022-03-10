package br.ufrj.diet.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link br.ufrj.diet.domain.AddFoodDataProcess} entity.
 */
public class AddFoodDataProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private FoodDTO food;

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

    public FoodDTO getFood() {
        return food;
    }

    public void setFood(FoodDTO food) {
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddFoodDataProcessDTO)) {
            return false;
        }

        AddFoodDataProcessDTO addFoodDataProcessDTO = (AddFoodDataProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, addFoodDataProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AddFoodDataProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", food=" + getFood() +
            "}";
    }
}
