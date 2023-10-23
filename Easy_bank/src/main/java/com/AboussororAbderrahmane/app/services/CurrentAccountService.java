package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.CurrentAccountDAOImp;
import com.AboussororAbderrahmane.app.entities.CurrentAccount;
import com.AboussororAbderrahmane.app.enums.accountStatus;

import java.util.Collections;
import java.util.List;

public class CurrentAccountService {

    private final CurrentAccountDAOImp currentAccountDAOImp;

    public CurrentAccountService(CurrentAccountDAOImp instance) {
        currentAccountDAOImp = instance;
    }

    public CurrentAccount save(CurrentAccount currentAccount) {

        return currentAccountDAOImp.save(currentAccount).orElse(null);

    }

    public  boolean delete(String number) {

        return currentAccountDAOImp.delete(number);
    }

    public List<CurrentAccount> findAll() {

        return currentAccountDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  CurrentAccount findByNumber(String number) {

        return currentAccountDAOImp.findByNumber(number).orElse(null);
    }

    public  List<CurrentAccount> findByClient(String clientCode) {

        return currentAccountDAOImp.findByClient(clientCode).orElse(null);
    }

    public  CurrentAccount findByOperationNumber(String operationNumber) {

        return currentAccountDAOImp.findByOperationNumber(operationNumber).orElse(null);
    }


    public  boolean update(CurrentAccount currentAccount) {

        return currentAccountDAOImp.update(currentAccount);
    }

    public  boolean updateStatus(accountStatus status, String number) {

        return currentAccountDAOImp.updateStatus(status, number);
    }

    public  boolean deposit(double balance, String number) {

        return currentAccountDAOImp.deposit(balance, number);

    }

    public  boolean withdraw(double balance, String number) {

        return currentAccountDAOImp.withdraw(balance, number);

    }

}
