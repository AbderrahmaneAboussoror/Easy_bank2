package com.AboussororAbderrahmane.app.model.person;

import com.AboussororAbderrahmane.app.model.account.Account;
import com.AboussororAbderrahmane.app.model.account.CurrentAccount;
import com.AboussororAbderrahmane.app.model.account.SavingAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Client extends Person{
    private String _code;
    private String _address;
    private List<Account> _accounts;
    private Employee _employee;
    public Client(String code, String firstName, String lastName, LocalDate birthDate, String phoneNumber, String address, Employee employee) {
        super(firstName, lastName, birthDate, phoneNumber);
        set_code(code);
        set_address(address);
        set_employee(employee);
    }
}
