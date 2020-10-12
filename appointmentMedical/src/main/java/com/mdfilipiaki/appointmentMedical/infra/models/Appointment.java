package com.mdfilipiaki.appointmentMedical.infra.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private User medic;

    @OneToOne
    private User customer;

    private Instant dateAppointment;

    public Appointment(final User medic, final User customer, final Instant dateAppointment) {
        this.medic = medic;
        this.customer = customer;
        this.dateAppointment = dateAppointment;
    }
}
