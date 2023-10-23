package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.RecruitmentHistoryDAOImp;
import com.AboussororAbderrahmane.app.entities.RecruitmentHistory;

import java.util.Collections;
import java.util.List;

public class RecruitmentHistoryService {

    public RecruitmentHistoryDAOImp recruitmentHistoryDAOImp;

    public RecruitmentHistoryService(RecruitmentHistoryDAOImp instance) {
        recruitmentHistoryDAOImp = instance;
    }

    public  RecruitmentHistory assignAnEmployeeToAnAgency(RecruitmentHistory recruitmentHistory) {

        return recruitmentHistoryDAOImp.assignAnEmployeeToAnAgency(recruitmentHistory).orElse(null);
    }

    public List<RecruitmentHistory> findAll() {

        return recruitmentHistoryDAOImp.findAll().orElse(Collections.emptyList());
    }
}
