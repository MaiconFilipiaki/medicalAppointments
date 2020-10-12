package com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mdfilipiaki.appointmentMedical.infra.Validations.ValidationConstants;
import com.mdfilipiaki.appointmentMedical.infra.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UserRequest {

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("email")
    @Email(regexp = ValidationConstants.EMAIL_REGEXP)
    @NotNull
    private String email;

    @JsonProperty("type")
    @NotNull
    private String type;


}
