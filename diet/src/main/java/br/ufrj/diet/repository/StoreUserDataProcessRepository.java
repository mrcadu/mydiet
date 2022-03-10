package br.ufrj.diet.repository;

import br.ufrj.diet.domain.StoreUserDataProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the StoreUserDataProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoreUserDataProcessRepository extends JpaRepository<StoreUserDataProcess, Long> {
    Optional<StoreUserDataProcess> findByProcessInstanceId(Long processInstanceId);
}
