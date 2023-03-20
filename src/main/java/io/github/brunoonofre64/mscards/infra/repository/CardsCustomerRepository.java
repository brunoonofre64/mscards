package io.github.brunoonofre64.mscards.infra.repository;

import io.github.brunoonofre64.mscards.domain.entities.CardsCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsCustomerRepository extends JpaRepository<CardsCustomerEntity, String> {
    List<CardsCustomerEntity> findByCpf(String cpf);
}
