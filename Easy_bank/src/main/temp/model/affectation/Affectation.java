package com.AboussororAbderrahmane.app.model.affectation;

import com.AboussororAbderrahmane.app.model.mission.Mission;
import com.AboussororAbderrahmane.app.model.person.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Affectation {
    private Employee employee;
    private Mission mission;
    private LocalDate startedAt;
    private LocalDate endedAt;
}
