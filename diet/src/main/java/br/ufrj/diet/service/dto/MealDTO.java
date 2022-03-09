package br.ufrj.diet.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link br.ufrj.diet.domain.Meal} entity.
 */
public class MealDTO implements Serializable {

    private Long id;

    private String name;

    private DietDTO diet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DietDTO getDiet() {
        return diet;
    }

    public void setDiet(DietDTO diet) {
        this.diet = diet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MealDTO)) {
            return false;
        }

        MealDTO mealDTO = (MealDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, mealDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MealDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", diet=" + getDiet() +
            "}";
    }
}
