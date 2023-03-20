package io.github.brunoonofre64.mscards.domain.exception;

import io.github.brunoonofre64.mscards.domain.enums.ErrorMessage;

public class BusinesRuleException extends RuntimeException {

    final ErrorMessage message;

    public BusinesRuleException(ErrorMessage message) {
        this.message = message;
    }
}
