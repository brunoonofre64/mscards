package io.github.brunoonofre64.mscards.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardsCustomerOutputDTO {
    private String name;
    private String cardFlag;
    private BigDecimal cardLimit;
}
