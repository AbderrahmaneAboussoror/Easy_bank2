package com.AboussororAbderrahmane.app.dao;

import java.util.List;
import java.util.Optional;

public interface IData <E, ID> {
    Optional<E> save (E entity);
    Optional<E> update (E entity);
    boolean delete(ID id);
    Optional<E> findById (ID id);
    List<E> findAll();

}
