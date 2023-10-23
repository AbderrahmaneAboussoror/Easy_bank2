package com.AboussororAbderrahmane.app.dao;

import com.AboussororAbderrahmane.app.entities.Person;

import java.util.Optional;

public interface IClientDAO<T> extends IPersonDAO<T> {

    Optional<T> findByAddress(String address);

}
