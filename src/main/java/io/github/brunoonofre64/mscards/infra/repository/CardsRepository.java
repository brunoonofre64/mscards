package io.github.brunoonofre64.mscards.infra.repository;

import io.github.brunoonofre64.mscards.domain.entities.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<CardsEntity, String> {
    List<CardsEntity> findByIncomeLessThanEqual(BigDecimal income);
    Optional<CardsEntity> findByUuid(String uuidCards);
}
