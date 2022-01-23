package com.pavan.project.projectmodule.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class AppointmentDto {
    private Long id;


    private String type;

    private LocalDate placed;

    private LocalDate appointment;

    private String doctorName;
}
