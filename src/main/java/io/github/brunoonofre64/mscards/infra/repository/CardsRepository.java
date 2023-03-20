package io.github.brunoonofre64.mscards.infra.repository;

import io.github.brunoonofre64.mscards.domain.entitie.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<CardsEntity, String> {
    List<CardsEntity> findByIncomeLessThanEqual(BigDecimal income);
}
