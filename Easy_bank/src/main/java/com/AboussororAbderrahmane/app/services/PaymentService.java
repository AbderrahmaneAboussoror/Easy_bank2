package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.PaymentDAOImp;
import com.AboussororAbderrahmane.app.entities.Operation;
import com.AboussororAbderrahmane.app.entities.Payment;

public class PaymentService {

    public PaymentDAOImp paymentDAOImp;

    public PaymentService(PaymentDAOImp instance) {
        paymentDAOImp = instance;
    }

    public Operation saveForCA(Payment payment) {

        return paymentDAOImp.saveForCA(payment).orElse(null);

    }

    public  Operation saveForSA(Payment payment) {

        return paymentDAOImp.saveForSA(payment).orElse(null);

    }

    public  boolean delete(String number) {

        return paymentDAOImp.delete(number);
    }

    public  Operation findByNumber(String number) {

        return paymentDAOImp.findByNumber(number).orElse(null);

    }

}
