package com.pavan.project.projectmodule.dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AppointmentDtoTests {
    @DisplayName("Dto : Checking Object Creation")
    @Test
    void testObjectCreation() {
        LocalDate dt=LocalDate.now();
        LocalDate dt2=LocalDate.now();
        var abc = new AppointmentDto(49L,"cancer",dt,dt2,"sri");
        Assertions.assertNotNull(abc);
    }

    @DisplayName("Dto : Checking Values")
    @Test
    void testObjectCreation2() {
        LocalDate dt=LocalDate.now();
        LocalDate dt2=LocalDate.now();
        var abc = new AppointmentDto(49L,"cancer",dt,dt2,"sri");
        Assertions.assertEquals(49,abc.getId());
        Assertions.assertEquals("cancer",abc.getType());
        Assertions.assertEquals((LocalDate.now()) ,abc.getPlaced());
        Assertions.assertEquals((LocalDate.now()),abc.getAppointment());
        Assertions.assertEquals("sri",abc.getDoctorName());
    }
}
