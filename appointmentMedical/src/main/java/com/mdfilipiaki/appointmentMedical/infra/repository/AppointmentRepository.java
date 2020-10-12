package com.mdfilipiaki.appointmentMedical.infra.repository;

import com.mdfilipiaki.appointmentMedical.infra.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> { }
