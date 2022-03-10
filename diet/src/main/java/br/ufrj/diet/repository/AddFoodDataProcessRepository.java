package br.ufrj.diet.repository;

import br.ufrj.diet.domain.AddFoodDataProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the AddFoodDataProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AddFoodDataProcessRepository extends JpaRepository<AddFoodDataProcess, Long> {
    Optional<AddFoodDataProcess> findByProcessInstanceId(Long processInstanceId);
}
