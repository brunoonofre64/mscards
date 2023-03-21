package io.github.brunoonofre64.mscards.infra.adapter;

import io.github.brunoonofre64.mscards.domain.enums.CardFlag;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CardFlagConverter implements AttributeConverter<CardFlag, String> {

    @Override
    public String convertToDatabaseColumn(CardFlag cardFlag) {
        if (cardFlag == null) {
            return null;
        }
        return cardFlag.name();
    }

    @Override
    public CardFlag convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return CardFlag.valueOf(dbData);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid value for CardFlag: " + dbData);
        }
    }
}
