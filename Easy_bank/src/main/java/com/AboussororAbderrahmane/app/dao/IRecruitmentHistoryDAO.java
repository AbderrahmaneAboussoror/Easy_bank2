package com.AboussororAbderrahmane.app.dao;

import com.AboussororAbderrahmane.app.entities.RecruitmentHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IRecruitmentHistoryDAO<T> {

    Optional<T> assignAnEmployeeToAnAgency(T t);
    Optional<List<T>> findAll();

}
