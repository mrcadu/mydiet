package br.ufrj.diet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Diet.
 */
@Entity
@Table(name = "diet")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "basal_metabolic_rate")
    private Float basalMetabolicRate;

    @Column(name = "calories_goal")
    private Float caloriesGoal;

    @Column(name = "protein")
    private Float protein;

    @Column(name = "carbohydrate")
    private Float carbohydrate;

    @Column(name = "fat")
    private Float fat;

    @OneToMany(mappedBy = "diet")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "foods", "diet" }, allowSetters = true)
    private Set<Meal> meals = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Diet id(Long id) {
        this.id = id;
        return this;
    }

    public Float getBasalMetabolicRate() {
        return this.basalMetabolicRate;
    }

    public Diet basalMetabolicRate(Float basalMetabolicRate) {
        this.basalMetabolicRate = basalMetabolicRate;
        return this;
    }

    public void setBasalMetabolicRate(Float basalMetabolicRate) {
        this.basalMetabolicRate = basalMetabolicRate;
    }

    public Float getCaloriesGoal() {
        return this.caloriesGoal;
    }

    public Diet caloriesGoal(Float caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
        return this;
    }

    public void setCaloriesGoal(Float caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public Float getProtein() {
        return this.protein;
    }

    public Diet protein(Float protein) {
        this.protein = protein;
        return this;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getCarbohydrate() {
        return this.carbohydrate;
    }

    public Diet carbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
        return this;
    }

    public void setCarbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Float getFat() {
        return this.fat;
    }

    public Diet fat(Float fat) {
        this.fat = fat;
        return this;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Set<Meal> getMeals() {
        return this.meals;
    }

    public Diet meals(Set<Meal> meals) {
        this.setMeals(meals);
        return this;
    }

    public Diet addMeals(Meal meal) {
        this.meals.add(meal);
        meal.setDiet(this);
        return this;
    }

    public Diet removeMeals(Meal meal) {
        this.meals.remove(meal);
        meal.setDiet(null);
        return this;
    }

    public void setMeals(Set<Meal> meals) {
        if (this.meals != null) {
            this.meals.forEach(i -> i.setDiet(null));
        }
        if (meals != null) {
            meals.forEach(i -> i.setDiet(this));
        }
        this.meals = meals;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Diet)) {
            return false;
        }
        return id != null && id.equals(((Diet) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Diet{" +
            "id=" + getId() +
            ", basalMetabolicRate=" + getBasalMetabolicRate() +
            ", caloriesGoal=" + getCaloriesGoal() +
            ", protein=" + getProtein() +
            ", carbohydrate=" + getCarbohydrate() +
            ", fat=" + getFat() +
            "}";
    }
}
