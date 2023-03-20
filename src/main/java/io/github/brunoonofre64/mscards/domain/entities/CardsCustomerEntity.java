package io.github.brunoonofre64.mscards.domain.entities;

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
public class CardsCustomerEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String uuid;

    @Column(nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "cards_id")
    private CardsEntity cards;

    @Column(nullable = false)
    private BigDecimal cardLimit;

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
