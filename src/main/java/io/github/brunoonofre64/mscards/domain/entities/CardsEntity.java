package io.github.brunoonofre64.mscards.domain.entities;

import io.github.brunoonofre64.mscards.domain.enums.FlagCard;
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlagCard flagCard;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false)
    private BigDecimal basicLimit;

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
