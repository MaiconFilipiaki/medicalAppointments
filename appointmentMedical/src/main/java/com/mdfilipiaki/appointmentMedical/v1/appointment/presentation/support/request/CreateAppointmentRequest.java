package com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@AllArgsConstructor
public class CreateAppointmentRequest {

    @JsonProperty("idMedic")
    @NotNull
    private Integer idMedic;

    @JsonProperty("idCustomer")
    @NotNull
    private Integer idCustomer;

    @JsonProperty("dateAppointment")
    @NotNull
    @JsonFormat(
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            shape = JsonFormat.Shape.STRING,
            timezone = "America/Sao_Paulo"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Instant dateAppointment;

}
