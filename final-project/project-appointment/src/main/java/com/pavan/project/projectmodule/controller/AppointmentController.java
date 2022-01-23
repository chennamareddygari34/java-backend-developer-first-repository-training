package com.pavan.project.projectmodule.controller;

import com.pavan.project.projectmodule.domain.Appointment;
import com.pavan.project.projectmodule.dto.AppResponse;
import com.pavan.project.projectmodule.dto.AppointmentDto;
import com.pavan.project.projectmodule.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/Appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService service;
    @PostMapping
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@Valid @RequestBody AppointmentDto dto) {

        var svObj = service.createAppointment(dto);
        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Appointment saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/setAppoint")
    public ResponseEntity<AppResponse<LocalDate>> activate(@Valid @RequestBody AppointmentDto dto) {
        LocalDate stat = service.setAppointment(dto.getId(),dto.getAppointment());
        var response = new AppResponse<LocalDate>();
        response.setMessage("Account Activated");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @PutMapping("/cancelAppoint")
    public ResponseEntity<AppResponse<String>> cancelAppointment(@Valid @RequestBody AppointmentDto dto) {
        String stat = service.cancelAppointment(dto.getId());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is removed");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/searchCanceledAppointment")
    public ResponseEntity<AppResponse<String>> cancelAppointment() {

        List<Appointment> list = service.searchCanceledAppointment();
        var response = new AppResponse<String>();
        response.setStatus("success");
        response.setMessage("All cancelled appointment");
        response.setList(list);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

        @GetMapping("/searchAppointmentsByDoctorName")
        public ResponseEntity<AppResponse<String>> searchAppointmentsByDoctorName(@RequestBody AppointmentDto dto) {

            List<Appointment> list=service.searchAppointmentsByDoctorName(dto.getDoctorName());
            var response =new AppResponse<String>();
            response.setMessage("success");
            response.setStatus("Appointment by Doctor Name");
            response.setList(list);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);

        }

    }



