package io.github.brunoonofre64.mscards.domain.mapper;

import io.github.brunoonofre64.mscards.domain.dto.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsInputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsOutputDTO;
import io.github.brunoonofre64.mscards.domain.entities.CardsCustomerEntity;
import io.github.brunoonofre64.mscards.domain.entities.CardsEntity;

import java.util.List;

public interface CardsMapper {
    CardsEntity mapperToEntity(CardsInputDTO inputDTO);
    List<CardsOutputDTO> mapperToOutputCardsList(List<CardsEntity> cards);
    List<CardsCustomerOutputDTO> mapperToOutputCardsCustomerList(List<CardsCustomerEntity> cardsCustomer);
}
