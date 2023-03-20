package io.github.brunoonofre64.mscards.domain.service;

import io.github.brunoonofre64.mscards.domain.dto.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsInputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsOutputDTO;

import java.util.List;

public interface CardsService {
    void saveNewCard(CardsInputDTO cardsInputDTO);
    List<CardsOutputDTO> findCardsIncomeLessThanEqual(Long income);
    List<CardsCustomerOutputDTO> findCardsCustomerByCpf(String cpf);
}
