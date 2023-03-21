package io.github.brunoonofre64.mscards.domain.entities;

import io.github.brunoonofre64.mscards.domain.enums.CardFlag;
import io.github.brunoonofre64.mscards.infra.adapter.CardFlagConverter;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardsEntity {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String uuid;

    @Column(nullable = false)
    private String name;

    @Convert(converter = CardFlagConverter.class)
    @Column(nullable = false)
    private CardFlag cardFlag;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false)
    private BigDecimal basicLimit;

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
