package io.github.brunoonofre64.mscards.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.brunoonofre64.mscards.domain.dto.DataRequestedIssuanceCardDTO;
import io.github.brunoonofre64.mscards.domain.entities.CardsCustomerEntity;
import io.github.brunoonofre64.mscards.domain.entities.CardsEntity;
import io.github.brunoonofre64.mscards.infra.repository.CardsCustomerRepository;
import io.github.brunoonofre64.mscards.infra.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IssuanceCardsSubscriber {

    private final CardsRepository cardsRepository;
    private final CardsCustomerRepository cardsCustomerRepository;

    @RabbitListener(queues = "${mq.queues.issuance-cards}")
    public void issuanceRequestMethod(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DataRequestedIssuanceCardDTO dataRequestedCard = mapper.readValue(payload, DataRequestedIssuanceCardDTO.class);

            CardsEntity card = cardsRepository.findByUuid(dataRequestedCard.getUuidCards())
                    .orElseThrow();

            CardsCustomerEntity cardsCustomer = CardsCustomerEntity
                    .builder()
                    .cards(card)
                    .cpf(dataRequestedCard.getCpf())
                    .cardLimit(dataRequestedCard.getLimitReleased())
                    .build();

            cardsCustomerRepository.save(cardsCustomer);

        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
}
