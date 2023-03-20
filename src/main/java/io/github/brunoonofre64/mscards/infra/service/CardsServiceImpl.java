package io.github.brunoonofre64.mscards.infra.service;

import io.github.brunoonofre64.mscards.domain.dto.CardsInputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsOutputDTO;
import io.github.brunoonofre64.mscards.domain.entitie.CardsEntity;
import io.github.brunoonofre64.mscards.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscards.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscards.domain.mapper.CardsMapper;
import io.github.brunoonofre64.mscards.domain.service.CardsService;
import io.github.brunoonofre64.mscards.infra.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {

    private final CardsRepository cardsRepository;
    private final CardsMapper mapper;

    @Override
    public void saveNewCard(CardsInputDTO cardsInputDTO) {
        if (cardsInputDTO == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        CardsEntity card = mapper.mapperToEntity(cardsInputDTO);
        cardsRepository.save(card);
    }

    @Override
    public List<CardsOutputDTO> findCardsIncomeLessThanEqual(Long income) {
        if (income == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        var incomeBigDecimal = BigDecimal.valueOf(income);
        List<CardsEntity> cards = cardsRepository.findByIncomeLessThanEqual(incomeBigDecimal);

        if (CollectionUtils.isEmpty(cards)) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return mapper.mapperToOutputCardsList(cards);
    }
}
