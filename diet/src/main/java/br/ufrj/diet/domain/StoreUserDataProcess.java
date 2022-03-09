package br.ufrj.diet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.akip.domain.ProcessInstance;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A StoreUserDataProcess.
 */
@Entity
@Table(name = "store_user_data_process")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StoreUserDataProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = { "processDefinition" }, allowSetters = true)
    private ProcessInstance processInstance;

    @ManyToOne
    private UserDiet userDiet;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreUserDataProcess id(Long id) {
        this.id = id;
        return this;
    }

    public ProcessInstance getProcessInstance() {
        return this.processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public StoreUserDataProcess processInstance(ProcessInstance processInstance) {
        this.setProcessInstance(processInstance);
        return this;
    }

    public UserDiet getUserDiet() {
        return this.userDiet;
    }

    public void setUserDiet(UserDiet userDiet) {
        this.userDiet = userDiet;
    }

    public StoreUserDataProcess UserDiet(UserDiet userDiet) {
        this.setUserDiet(userDiet);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreUserDataProcess)) {
            return false;
        }
        return id != null && id.equals(((StoreUserDataProcess) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StoreUserDataProcess{" +
            "id=" + getId() +
            "}";
    }
}
