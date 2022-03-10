package br.ufrj.diet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Food.
 */
@Entity
@Table(name = "food")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "grams")
    private Float grams;

    @Column(name = "protein")
    private Float protein;

    @Column(name = "carbohydrate")
    private Float carbohydrate;

    @Column(name = "fat")
    private Float fat;

    @Column(name = "calories")
    private Float calories;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JsonIgnoreProperties(value = { "foods", "diet" }, allowSetters = true)
    private Meal meal;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Food name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGrams() {
        return this.grams;
    }

    public Food grams(Float grams) {
        this.grams = grams;
        return this;
    }

    public void setGrams(Float grams) {
        this.grams = grams;
    }

    public Float getProtein() {
        return this.protein;
    }

    public Food protein(Float protein) {
        this.protein = protein;
        return this;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getCarbohydrate() {
        return this.carbohydrate;
    }

    public Food carbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
        return this;
    }

    public void setCarbohydrate(Float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Float getFat() {
        return this.fat;
    }

    public Food fat(Float fat) {
        this.fat = fat;
        return this;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getCalories() {
        return this.calories;
    }

    public Food calories(Float calories) {
        this.calories = calories;
        return this;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public String getUsername() {
        return this.username;
    }

    public Food username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Meal getMeal() {
        return this.meal;
    }

    public Food meal(Meal meal) {
        this.setMeal(meal);
        return this;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Food)) {
            return false;
        }
        return id != null && id.equals(((Food) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Food{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", grams=" + getGrams() +
            ", protein=" + getProtein() +
            ", carbohydrate=" + getCarbohydrate() +
            ", fat=" + getFat() +
            ", calories=" + getCalories() +
            ", username='" + getUsername() + "'" +
            "}";
    }
}
