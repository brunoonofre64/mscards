package io.github.brunoonofre64.mscards.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class IssuanceCardsSubscriber {

    @RabbitListener(queues = "${mq.queues.issuance-cards}")
    public void issuanceRequestMethod(@Payload String payload) {
        System.out.println(payload);
    }
}