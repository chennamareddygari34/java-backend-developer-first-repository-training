package com.pavan.project.projectmodule.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Appointment {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false)
    private String type;

    @Column(unique = false, nullable = false)
    private LocalDate placed;

    @Column(unique = false, nullable = false)
    private LocalDate appointment;

    @Column(unique = true, nullable = true)
    private String doctorName;

}

