package com.AboussororAbderrahmane.app.dao.scripts.AgencyDAO;

import com.AboussororAbderrahmane.app.model.agency.Agency;

import java.util.List;
import java.util.Optional;

public class AgencyDAO implements IAgencyDAO{
    @Override
    public List<Agency> findAll() {
        return null;
    }

    @Override
    public Optional<Agency> save(Agency entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Agency> update(Agency entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Agency> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
