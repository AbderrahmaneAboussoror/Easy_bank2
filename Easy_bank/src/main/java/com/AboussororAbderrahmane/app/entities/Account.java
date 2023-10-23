package com.AboussororAbderrahmane.app.entities;


import java.time.LocalDate;
import java.util.List;

import com.AboussororAbderrahmane.app.enums.accountStatus;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Account {

    private String number;
    private double balance;
    private LocalDate createdAt;
    private accountStatus status;
    private Agency agency;
    private Client client;
    private Employee employee;
    private List<Operation> operations;

}
