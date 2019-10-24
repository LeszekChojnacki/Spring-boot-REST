package org.HappyRestApi.springREST.domain.enums;

public enum Period {

    ONE_MONTH(1),
    THREE_MONTHS(3),
    SIX_MONTHS(6),
    TWELVE_MONTHS(12);

    private final int value;

    Period (final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
