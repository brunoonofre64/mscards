package io.github.brunoonofre64.mscards.infra.mapper;

import io.github.brunoonofre64.mscards.domain.dto.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsInputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsOutputDTO;
import io.github.brunoonofre64.mscards.domain.entities.CardsCustomerEntity;
import io.github.brunoonofre64.mscards.domain.entities.CardsEntity;
import io.github.brunoonofre64.mscards.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscards.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscards.domain.mapper.CardsMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardsMapperImpl implements CardsMapper {


    @Override
    public CardsEntity mapToEntity(CardsInputDTO inputDTO) {
        if (inputDTO == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return CardsEntity
                .builder()
                .name(inputDTO.getName())
                .cardFlag(inputDTO.getCardFlag())
                .income(inputDTO.getIncome())
                .basicLimit(inputDTO.getBasicLimit())
                .build();
    }

    @Override
    public List<CardsOutputDTO> mapToOutputCardsList(List<CardsEntity> cards) {
        if (CollectionUtils.isEmpty(cards)) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return cards
                .stream()
                .map(this::mapToCardsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CardsCustomerOutputDTO> mapToOutputCardsCustomerList(List<CardsCustomerEntity> cardsCustomer) {
        if (CollectionUtils.isEmpty(cardsCustomer)) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return cardsCustomer
                .stream()
                .map(this::mapToCardsCustomerDTO)
                .collect(Collectors.toList());
    }

    private CardsCustomerOutputDTO mapToCardsCustomerDTO(CardsCustomerEntity cardsCustomer) {
        if (cardsCustomer == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return CardsCustomerOutputDTO
                .builder()
                .name(cardsCustomer.getCards().getName())
                .cardFlag(cardsCustomer.getCards().getCardFlag().name())
                .cardLimit(cardsCustomer.getCardLimit())
                .build();
    }

    private CardsOutputDTO mapToCardsDTO(CardsEntity cards) {
        if (cards == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return CardsOutputDTO
                .builder()
                .name(cards.getName())
                .cardFlag(cards.getCardFlag().name())
                .income(cards.getIncome())
                .basicLimit(cards.getBasicLimit())
                .build();
    }
}
