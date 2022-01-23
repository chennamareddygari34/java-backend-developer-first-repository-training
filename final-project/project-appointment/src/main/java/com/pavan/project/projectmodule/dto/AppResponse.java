package com.pavan.project.projectmodule.dto;
import com.pavan.project.projectmodule.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class AppResponse<T> {
    private String status;
    private String message;
    private T body;
    private List<Appointment> list;


  //  public void setStatus(String status) {
   // }

  //  public void setStatus(LocalDate stat) {
  //  }

  //  public void setList(List<Appointment> list) {
    //}

}
