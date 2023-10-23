package com.AboussororAbderrahmane.app.model.person;

import com.AboussororAbderrahmane.app.model.account.Account;
import com.AboussororAbderrahmane.app.model.account.CurrentAccount;
import com.AboussororAbderrahmane.app.model.account.SavingAccount;
import com.AboussororAbderrahmane.app.model.affectation.Affectation;
import com.AboussororAbderrahmane.app.model.operation.Operation;
import com.AboussororAbderrahmane.app.model.recruitment.Recruitment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Employee extends Person{
    private String _code;
    private String _email;
    private LocalDate _recruitedAt;
    private List<Account> _accounts;
    private List<Operation> _operations;
    private List<Affectation> _affectations;
    private List<Recruitment> _recruitments;

    public Employee(String code, String firstName, String lastName, LocalDate birthDate, String phoneNumber, String email, LocalDate recruitedAt) {
        super(firstName, lastName, birthDate, phoneNumber);
        this._code = code;
        this._email = email;
        this._recruitedAt = recruitedAt;
    }
}
