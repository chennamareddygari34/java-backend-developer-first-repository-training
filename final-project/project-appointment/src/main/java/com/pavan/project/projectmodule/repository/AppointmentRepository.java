package com.pavan.project.projectmodule.repository;
import com.pavan.project.projectmodule.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    List<Appointment> findAllByType(String s);
    List<Appointment> findAllByDoctorName(String s);
}
