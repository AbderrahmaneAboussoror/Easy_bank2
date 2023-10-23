package com.AboussororAbderrahmane.app.model.recruitment;

import com.AboussororAbderrahmane.app.model.agency.Agency;
import com.AboussororAbderrahmane.app.model.person.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruitment {
    private Employee employee;
    private Agency agency;
    private LocalDate recruitedAt;
    private LocalDate finishedAt;
}
