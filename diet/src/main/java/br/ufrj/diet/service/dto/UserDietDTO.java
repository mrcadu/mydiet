package br.ufrj.diet.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link br.ufrj.diet.domain.UserDiet} entity.
 */
public class UserDietDTO implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private String genre;

    private String biotype;

    private String goal;

    private Integer weight;

    private Integer height;

    private Integer neck;

    private Integer waist;

    private Integer hip;

    private Integer bodyFat;

    private DietDTO diet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBiotype() {
        return biotype;
    }

    public void setBiotype(String biotype) {
        this.biotype = biotype;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getNeck() {
        return neck;
    }

    public void setNeck(Integer neck) {
        this.neck = neck;
    }

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getHip() {
        return hip;
    }

    public void setHip(Integer hip) {
        this.hip = hip;
    }

    public Integer getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(Integer bodyFat) {
        this.bodyFat = bodyFat;
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
        if (!(o instanceof UserDietDTO)) {
            return false;
        }

        UserDietDTO userDietDTO = (UserDietDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, userDietDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserDietDTO{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", age=" + getAge() +
            ", genre='" + getGenre() + "'" +
            ", biotype='" + getBiotype() + "'" +
            ", goal='" + getGoal() + "'" +
            ", weight=" + getWeight() +
            ", height=" + getHeight() +
            ", neck=" + getNeck() +
            ", waist=" + getWaist() +
            ", hip=" + getHip() +
            ", bodyFat=" + getBodyFat() +
            ", diet=" + getDiet() +
            "}";
    }
}
