package com.pavan.project.projectmodule.service;
import com.pavan.project.projectmodule.domain.Appointment;
import com.pavan.project.projectmodule.dto.AppointmentDto;
import com.pavan.project.projectmodule.exception.AppointementAlreadyExisting;
import com.pavan.project.projectmodule.exception.DateOutOfBound;
import com.pavan.project.projectmodule.exception.DuplicateException;

import java.time.LocalDate;
import java.util.List;


public interface AppointmentService {
    public AppointmentDto createAppointment(AppointmentDto dto)throws DuplicateException;

    LocalDate setAppointment(Long id, LocalDate appointment, String type) throws DateOutOfBound, AppointmentAlreadyExisting;

    String cancelAppointment(Long id);

    List<Appointment> searchCanceledAppointment();

    List<Appointment> searchAppointmentsByDoctorName(String s);


}