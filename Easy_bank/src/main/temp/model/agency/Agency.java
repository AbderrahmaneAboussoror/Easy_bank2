package com.AboussororAbderrahmane.app.model.agency;

import com.AboussororAbderrahmane.app.model.account.Account;
import com.AboussororAbderrahmane.app.model.demand.Demand;
import com.AboussororAbderrahmane.app.model.person.Employee;
import com.AboussororAbderrahmane.app.model.recruitment.Recruitment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agency {
    protected String _code;
    protected String _name;
    protected String _address;
    protected String _phoneNumber;
    protected List<Account> _accounts;
    protected List<Demand> _demands;
    protected List<Recruitment> _recruitments;
}
