package com.app.rbms.services.impl;

import com.app.rbms.daos.ContainDAO;
import com.app.rbms.entities.Contain;
import com.app.rbms.services.ContainService;

public class ContainServiceImpl implements ContainService {

    private final ContainDAO containDAO;

    public ContainServiceImpl(ContainDAO containDAO) {
        this.containDAO = containDAO;
    }

    @Override
    public boolean saveContain(Contain contain) {
        return containDAO.saveOrUpdate(contain);
    }

    @Override
    public boolean deleteContain(Contain contain) {
        return containDAO.delete(contain);
    }

    @Override
    public boolean deleteContain(long bookCaseID) {
        return containDAO.delete(bookCaseID);
    }
}
