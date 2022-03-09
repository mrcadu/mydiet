package br.ufrj.diet.repository;

import br.ufrj.diet.domain.Food;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Food entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {}
