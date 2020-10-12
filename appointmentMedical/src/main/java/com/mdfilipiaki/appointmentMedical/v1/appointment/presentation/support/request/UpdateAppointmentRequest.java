package com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class UpdateAppointmentRequest extends CreateAppointmentRequest {

    public UpdateAppointmentRequest(
            final Integer id,
            final @NotNull Integer idMedic,
            final @NotNull Integer idCustomer,
            final @NotNull Instant dateAppointment) {
        super(idMedic, idCustomer, dateAppointment);
        this.id = id;
    }

    @JsonProperty("id")
    @NotNull
    private Integer id;

}
