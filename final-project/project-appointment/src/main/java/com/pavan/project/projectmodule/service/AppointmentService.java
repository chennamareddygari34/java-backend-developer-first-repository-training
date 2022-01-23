package com.pavan.project.projectmodule.service;
import com.pavan.project.projectmodule.domain.Appointment;
import com.pavan.project.projectmodule.dto.AppointmentDto;

import java.time.LocalDate;
import java.util.List;


public interface AppointmentService {
    public AppointmentDto createAppointment(AppointmentDto dto);

    LocalDate setAppointment(Long id,LocalDate appointment);

    String cancelAppointment(Long id);

    List<Appointment> searchCanceledAppointment();

    List<Appointment> searchAppointmentsByDoctorName(String s);
}
