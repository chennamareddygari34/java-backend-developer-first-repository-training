package com.pavan.project.projectmodule.repository;
import com.pavan.project.projectmodule.domain.Appointment;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryTests {
    @Autowired
    private AppointmentRepository repository;

    @DisplayName("Appointment repo : creating ")
    @Test
    public void testCreateAppointment(){
        var appointment = new Appointment();
        appointment.setId(11L);
        appointment.setType("hiv");
        appointment.setAppointment(LocalDate.now());
        appointment.setDoctorName("ravi");
        appointment.setPlaced(LocalDate.now());

        repository.save(appointment);
    }
}
