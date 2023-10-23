package com.AboussororAbderrahmane.app.model.account;

import com.AboussororAbderrahmane.app.model.person.Client;
import com.AboussororAbderrahmane.app.model.person.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor

public final class SavingAccount extends Account{

    private double _interestRate;
    public SavingAccount(String number, Double balance, LocalDate createdAt, Employee employee, Client client, Double interestRate) {
        super(number, balance, createdAt, employee, client);
        set_interestRate(interestRate);
    }
}
