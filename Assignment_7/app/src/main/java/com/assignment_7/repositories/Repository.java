package com.assignment_7.repositories;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by 214162966 on 4/18/2016.
 */
public interface  Repository<E,ID> {
    E findById(ID id);

    E save(E entity) throws SQLException;

    E update(E entity) throws SQLException;

    E delete(E entity) throws SQLException;

    Set<E> findAll() throws SQLException;

    int deleteAll() throws SQLException;
}
