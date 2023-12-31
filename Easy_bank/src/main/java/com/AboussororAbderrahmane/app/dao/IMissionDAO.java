package com.AboussororAbderrahmane.app.dao;

import com.AboussororAbderrahmane.app.entities.Mission;

import java.util.List;
import java.util.Optional;

public interface IMissionDAO<T> extends IDataDAO<T> {

    Optional<T> findByCode(String code);

}
