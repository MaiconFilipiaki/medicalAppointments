package com.mdfilipiaki.appointmentMedical.infra.enumeration;

import java.util.function.Predicate;

public interface EnumValue {

    String getValue();

    static Predicate<? super EnumValue> equalsToValue(final Object value) {
        return enumValue -> enumValue.getValue().equals(value);
    }

}
