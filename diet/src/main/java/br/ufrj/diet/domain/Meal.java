package br.ufrj.diet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Meal.
 */
@Entity
@Table(name = "meal")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Meal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "meal")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "meal" }, allowSetters = true)
    private Set<Food> foods = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "meals" }, allowSetters = true)
    private Diet diet;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Meal id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Meal name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Food> getFoods() {
        return this.foods;
    }

    public Meal foods(Set<Food> foods) {
        this.setFoods(foods);
        return this;
    }

    public Meal addFoods(Food food) {
        this.foods.add(food);
        food.setMeal(this);
        return this;
    }

    public Meal removeFoods(Food food) {
        this.foods.remove(food);
        food.setMeal(null);
        return this;
    }

    public void setFoods(Set<Food> foods) {
        if (this.foods != null) {
            this.foods.forEach(i -> i.setMeal(null));
        }
        if (foods != null) {
            foods.forEach(i -> i.setMeal(this));
        }
        this.foods = foods;
    }

    public Diet getDiet() {
        return this.diet;
    }

    public Meal diet(Diet diet) {
        this.setDiet(diet);
        return this;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Meal)) {
            return false;
        }
        return id != null && id.equals(((Meal) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Meal{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
