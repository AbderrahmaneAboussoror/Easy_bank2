package com.AboussororAbderrahmane.app.model.account;

import com.AboussororAbderrahmane.app.model.agency.Agency;
import com.AboussororAbderrahmane.app.model.operation.Operation;
import com.AboussororAbderrahmane.app.model.person.Client;
import com.AboussororAbderrahmane.app.model.person.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {

    protected String _number;
    protected Double _balance;
    protected LocalDate _createdAt;
    protected AccountStatus _status;
    protected Employee _employee;
    protected Client _client;
    protected List<Operation> _operations;
    protected Agency _agency;

    protected Account(String number, Double balance, LocalDate createdAt, Employee employee, Client client, List<Operation> operations, Agency agency) {
        set_number(number);
        set_balance(balance);
        set_createdAt(createdAt);
        set_employee(employee);
        set_client(client);
        set_operations(operations);
        set_agency(agency);
    }

}
