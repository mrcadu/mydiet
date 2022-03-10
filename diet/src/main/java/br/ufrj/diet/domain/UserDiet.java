package br.ufrj.diet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A UserDiet.
 */
@Entity
@Table(name = "user_diet")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDiet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private Integer age;

    @Column(name = "genre")
    private String genre;

    @Column(name = "biotype")
    private String biotype;

    @Column(name = "goal")
    private String goal;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "height")
    private Integer height;

    @Column(name = "neck")
    private Integer neck;

    @Column(name = "waist")
    private Integer waist;

    @Column(name = "hip")
    private Integer hip;

    @Column(name = "body_fat")
    private Integer bodyFat;

    @JsonIgnoreProperties(value = { "meals" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private Diet diet;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDiet id(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public UserDiet username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public UserDiet password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return this.age;
    }

    public UserDiet age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return this.genre;
    }

    public UserDiet genre(String genre) {
        this.genre = genre;
        return this;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBiotype() {
        return this.biotype;
    }

    public UserDiet biotype(String biotype) {
        this.biotype = biotype;
        return this;
    }

    public void setBiotype(String biotype) {
        this.biotype = biotype;
    }

    public String getGoal() {
        return this.goal;
    }

    public UserDiet goal(String goal) {
        this.goal = goal;
        return this;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public UserDiet weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return this.height;
    }

    public UserDiet height(Integer height) {
        this.height = height;
        return this;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getNeck() {
        return this.neck;
    }

    public UserDiet neck(Integer neck) {
        this.neck = neck;
        return this;
    }

    public void setNeck(Integer neck) {
        this.neck = neck;
    }

    public Integer getWaist() {
        return this.waist;
    }

    public UserDiet waist(Integer waist) {
        this.waist = waist;
        return this;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getHip() {
        return this.hip;
    }

    public UserDiet hip(Integer hip) {
        this.hip = hip;
        return this;
    }

    public void setHip(Integer hip) {
        this.hip = hip;
    }

    public Integer getBodyFat() {
        return this.bodyFat;
    }

    public UserDiet bodyFat(Integer bodyFat) {
        this.bodyFat = bodyFat;
        return this;
    }

    public void setBodyFat(Integer bodyFat) {
        this.bodyFat = bodyFat;
    }

    public Diet getDiet() {
        return this.diet;
    }

    public UserDiet diet(Diet diet) {
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
        if (!(o instanceof UserDiet)) {
            return false;
        }
        return id != null && id.equals(((UserDiet) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserDiet{" +
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
            "}";
    }
}
