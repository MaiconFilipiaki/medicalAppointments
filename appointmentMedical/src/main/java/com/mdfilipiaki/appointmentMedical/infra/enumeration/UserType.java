package com.mdfilipiaki.appointmentMedical.infra.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType implements EnumValue {

    MEDIC("MEDIC"),
    CUSTOMER("CUSTOMER")
    ;

    @JsonValue
    private final String value;

    public static UserType toEnum(final String value) {
        if (value == null) {
            return null;
        }

        for (UserType x : UserType.values()) {
            if (value.equals(x.getValue())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Value invalid: " + value);
    }

}
