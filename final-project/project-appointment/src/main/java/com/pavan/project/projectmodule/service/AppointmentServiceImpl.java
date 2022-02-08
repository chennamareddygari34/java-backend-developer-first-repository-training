package com.pavan.project.projectmodule.service;

import com.pavan.project.projectmodule.domain.Appointment;
import com.pavan.project.projectmodule.dto.AppointmentDto;
import com.pavan.project.projectmodule.exception.AppointementAlreadyExisting;
import com.pavan.project.projectmodule.exception.DateOutOfBound;
import com.pavan.project.projectmodule.exception.DuplicateException;
import com.pavan.project.projectmodule.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository repository;

    @Override

    public AppointmentDto createAppointment(AppointmentDto dto)  throws DuplicateException {

        try {
            var appointment = new Appointment();
            appointment.setType(dto.getType());
            appointment.setAppointment(dto.getAppointment());
            appointment.setPlaced(dto.getPlaced());
            appointment.setDoctorName(dto.getDoctorName());

            repository.save(appointment);
            return dto;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateException("You have entered duplicate key value");
        }
    }

    @Override
    public LocalDate setAppointment(Long id, LocalDate appointment, String type) throws DateOutOfBound, AppointmentAlreadyExisting {

        Optional<Appointment> op = repository.findById(id);
        Appointment baOld = op.orElseThrow();
        LocalDate existingAppointment = baOld.getAppointment();
        LocalDate today = LocalDate.from(LocalDateTime.now());
        int compareValue = today.compareTo(appointment);
        if (compareValue > 0) throw new DateOutOfBound("Given date is not exceeding today's date");
        String existingType = baOld.getType();
        LocalDate newAppointment = appointment;
        String newType = type;
        Appointment baNew = new Appointment();
        baNew.setAppointment(appointment);
        baNew.setId(baOld.getId());
        baNew.setType(newType);
        baNew.setPlaced(baOld.getPlaced());
        baNew.setDoctorName(baOld.getDoctorName());
        repository.save(baNew);
        return baNew.getAppointment();

    }


    @Override
    public String cancelAppointment(Long id) {
//      Optional<Appointment> op = repository.findById(id);
//    Appointment apOld = op.orElseThrow();
//        String existingType = apOld.getType();
//        String newType = type;
//        Appointment apNew = new Appointment();
//        apNew.setAppointment(apOld.getAppointment());
//        apNew.setId(apOld.getId());
//        apNew.setType(newType);
//        apNew.setPlaced(apOld.getPlaced());
//        apNew.setDoctorName(apOld.getDoctorName());
//        repository.save(apNew);
//        return apNew.getType();
        Appointment op = repository.getById(id);
        String existingType = op.getType();
        String newType = "cancel";
        op.setType(newType);
        repository.save(op);
        return op.getType();
    }

    @Override
    public List<Appointment> searchCanceledAppointment() {
        List<Appointment> list = repository.findAllByType("cancel");
        return list;
    }

    @Override
    public List<Appointment> searchAppointmentsByDoctorName(String s) {
        List<Appointment> list = repository.findAllByDoctorName(s);
        return list;
    }
}

