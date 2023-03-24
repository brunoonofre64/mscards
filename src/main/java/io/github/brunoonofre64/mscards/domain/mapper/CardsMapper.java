package io.github.brunoonofre64.mscards.domain.mapper;

import io.github.brunoonofre64.mscards.domain.dto.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsInputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsOutputDTO;
import io.github.brunoonofre64.mscards.domain.entities.CardsCustomerEntity;
import io.github.brunoonofre64.mscards.domain.entities.CardsEntity;

import java.util.List;

public interface CardsMapper {
    CardsEntity mapToEntity(CardsInputDTO inputDTO);
    List<CardsOutputDTO> mapToOutputCardsList(List<CardsEntity> cards);
    List<CardsCustomerOutputDTO> mapToOutputCardsCustomerList(List<CardsCustomerEntity> cardsCustomer);
}
