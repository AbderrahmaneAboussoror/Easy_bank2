package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.MissionDAOImp;
import com.AboussororAbderrahmane.app.entities.Mission;

import java.util.Collections;
import java.util.List;

public class MissionService {

    private final MissionDAOImp missionDAOImp;

    public MissionService(MissionDAOImp instance) {
        missionDAOImp= instance;
    }

    public Mission findByCode(String code) {

        return missionDAOImp.findByCode(code).orElse(null);
    }

    public  Mission save(Mission mission) {

        return missionDAOImp.save(mission).orElse(null);

    }

    public  boolean delete(String code) {

        return missionDAOImp.delete(code);
    }

    public List<Mission> findAll() {

        return missionDAOImp.findAll().orElse(Collections.emptyList());
    }
}
