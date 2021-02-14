package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.util.List;

public class TaxiOrderDAO extends DAO {


    @Override
    public boolean update(Object entity) throws DAOException {
        return false;
    }

    @Override
    public int insert(Object entity) throws DAOException {
        return 0;
    }

    @Override
    public void delete() throws DAOException {

    }

    @Override
    public void delete(long id) throws DAOException {
    }

    @Override
    public void deleteById(Object entity) throws DAOException {

    }

    @Override
    public Object selectById(long id) throws DAOException {
        return null;
    }

    @Override
    public List select() throws DAOException {
        return null;
    }
}
