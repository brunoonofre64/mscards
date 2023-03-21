package io.github.brunoonofre64.mscards.domain.enums;

public enum CardFlag {
    MASTERCARD("MASTERCARD"),
    VISA("VISA");

    final String value;

    CardFlag(String value) {
        this.value = value;
    }
}
