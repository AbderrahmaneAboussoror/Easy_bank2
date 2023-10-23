package com.AboussororAbderrahmane.app.dao;

import com.AboussororAbderrahmane.app.enums.demandStatus;

import java.util.Optional;

public interface IDemandDAO<T> extends IDataDAO<T> {

    Optional<T> findByNumber(String number);
    boolean updateStatus(demandStatus status, String number);

}
