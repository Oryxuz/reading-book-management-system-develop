package com.app.rbms.daos;

import com.app.rbms.entities.Contain;

public interface ContainDAO {
    boolean saveOrUpdate(Contain contain);

    boolean delete(Contain contain);

    boolean delete(long id);
}
