package io.github.brunoonofre64.mscards.domain.dto;

import io.github.brunoonofre64.mscards.domain.enums.FlagCard;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardsCustomerOutputDTO {
    private String name;
    private FlagCard flagCard;
    private BigDecimal cardLimit;
}
