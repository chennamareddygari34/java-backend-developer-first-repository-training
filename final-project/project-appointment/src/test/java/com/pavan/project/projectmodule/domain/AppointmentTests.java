package com.pavan.project.projectmodule.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
public class AppointmentTests {
    @DisplayName("Domain : Checking Object Creation")
    @Test
    void testObjectCreation() {
        var abc = new Appointment();
        Assertions.assertNotNull(abc);
    }

    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var abc = new Appointment();
        abc.setId(49L);
        abc.setType("cancer");
        abc.setAppointment(LocalDate.of(2021,1,1));
        abc.setPlaced(LocalDate.of(2021,1,1));
        abc.setDoctorName("sri");

        Assertions.assertEquals(49, abc.getId());
        Assertions.assertEquals("cancer" , abc.getType());
        Assertions.assertEquals(
                (LocalDate.of(2021,1,1)),
                abc.getAppointment()
        );
        Assertions.assertEquals(
                (LocalDate.of(2021,1,1)),
                abc.getPlaced()
        );
        Assertions.assertEquals("sri",abc.getDoctorName());
    }
}
