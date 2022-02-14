package br.ufrj.diet.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link br.ufrj.diet.domain.Diet} entity.
 */
public class DietDTO implements Serializable {

    private Long id;

    private Float basalMetabolicRate;

    private Float caloriesGoal;

    private Float protein;

    private Float carbohydrate;

    private Float fat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBasalMetabolicRate() {
        return basalMetabolicRate;
    }

    public void setBasalMetabolicRate(Float basalMetabolicRate) {
        this.basalMetabolicRate = basalMetabolicRate;
    }

    public Float getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(Float caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DietDTO)) {
            return false;
        }

        DietDTO dietDTO = (DietDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, dietDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DietDTO{" +
            "id=" + getId() +
            ", basalMetabolicRate=" + getBasalMetabolicRate() +
            ", caloriesGoal=" + getCaloriesGoal() +
            ", protein=" + getProtein() +
            ", carbohydrate=" + getCarbohydrate() +
            ", fat=" + getFat() +
            "}";
    }
}
