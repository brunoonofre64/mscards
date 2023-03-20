package io.github.brunoonofre64.mscards.domain.dto;

import io.github.brunoonofre64.mscards.domain.enums.FlagCard;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardsInputDTO {
    private String name;
    private FlagCard flagCard;
    private BigDecimal income;
    private BigDecimal basicLimit;
}
