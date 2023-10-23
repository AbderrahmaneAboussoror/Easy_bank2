package com.AboussororAbderrahmane.app.model.operation;

import com.AboussororAbderrahmane.app.model.account.Account;
import com.AboussororAbderrahmane.app.model.person.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private String _number;
    private LocalDate _createdAt;
    private double _price;
    private paymentType _payment;
    private Employee _employee;
    private Account _account;
}
