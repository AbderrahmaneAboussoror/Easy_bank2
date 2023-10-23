package com.AboussororAbderrahmane.app.model.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    protected String _firstName;
    protected String _lastName;
    protected LocalDate _birthDate;
    protected String _phoneNumber;
}
