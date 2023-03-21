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
    public CardsEntity mapperToEntity(CardsInputDTO inputDTO) {
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
    public List<CardsOutputDTO> mapperToOutputCardsList(List<CardsEntity> cards) {
        if (CollectionUtils.isEmpty(cards)) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return cards
                .stream()
                .map(this::mapperToCardsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CardsCustomerOutputDTO> mapperToOutputCardsCustomerList(List<CardsCustomerEntity> cardsCustomer) {
        if (CollectionUtils.isEmpty(cardsCustomer)) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return cardsCustomer
                .stream()
                .map(this::mapperToCardsCustomerDTO)
                .collect(Collectors.toList());
    }

    private CardsCustomerOutputDTO mapperToCardsCustomerDTO(CardsCustomerEntity cardsCustomer) {
        if (cardsCustomer == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return CardsCustomerOutputDTO
                .builder()
                .name(cardsCustomer.getCards().getName())
                .cardFlag(cardsCustomer.getCards().getCardFlag())
                .cardLimit(cardsCustomer.getCardLimit())
                .build();
    }

    private CardsOutputDTO mapperToCardsDTO(CardsEntity cards) {
        if (cards == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return CardsOutputDTO
                .builder()
                .name(cards.getName())
                .cardFlag(cards.getCardFlag())
                .income(cards.getIncome())
                .basicLimit(cards.getBasicLimit())
                .build();
    }
}
