package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.MissionHistoryDAOImp;
import com.AboussororAbderrahmane.app.entities.MissionHistory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class MissionHistoryService {

    private final MissionHistoryDAOImp missionHistoryDAOImp;

    public MissionHistoryService(MissionHistoryDAOImp instance) {
        missionHistoryDAOImp = instance;
    }

    public  MissionHistory save(MissionHistory missionHistory) {

        return missionHistoryDAOImp.save(missionHistory).orElse(null);

    }

    public  boolean delete(String employeeCode, String missionCode, LocalDate startedAt) {

        return missionHistoryDAOImp.delete(employeeCode, missionCode, startedAt);
    }

    public List<MissionHistory> findAll() {

        return missionHistoryDAOImp.findAll().orElse(Collections.emptyList());

    }

}
