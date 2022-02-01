package com.pavan.project.projectmodule.controller;
import com.pavan.project.projectmodule.domain.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerTests {
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @DisplayName("GET - Appointment - Checking Object is non null")
    @Test
    public void testGetMethod() {

        String url = "http://" + "localhost" +":" + port +"/Appointment";

        Appointment app = template.getForObject( // GET method
                url,
                Appointment.class
        );

        Assertions.assertNotNull(app);
    }

}

