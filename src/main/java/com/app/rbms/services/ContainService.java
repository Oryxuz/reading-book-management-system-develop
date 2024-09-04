package com.app.rbms.services;

import com.app.rbms.entities.Contain;

public interface ContainService {
    boolean saveContain(Contain contain);

    boolean deleteContain(Contain contain);

    boolean deleteContain(long bookCaseID);
}
