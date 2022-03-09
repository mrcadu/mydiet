package br.ufrj.diet.repository;

import br.ufrj.diet.domain.UserDiet;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the UserDiet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserDietRepository extends JpaRepository<UserDiet, Long> {}
