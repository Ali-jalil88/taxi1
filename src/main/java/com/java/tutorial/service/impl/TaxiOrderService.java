package com.java.tutorial.service.impl;

import com.java.tutorial.dao.impl.TaxiOrderDAO;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.CRUDService;

import java.util.List;

public class TaxiOrderService extends CRUDService {
    TaxiOrderDAO taxiOrderDAO = new TaxiOrderDAO();
    @Override
    public void create(Object entity) throws ServiceException {

    }

    @Override
    public Object readById(long id) throws ServiceException {
        try {
            return taxiOrderDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("can't read taxiOrder by id");
        }
    }

    @Override
    public List read() throws ServiceException {
        return null;
    }

    @Override
    public void update(Object entity) throws ServiceException {

    }

    @Override
    public void delete() throws ServiceException {

    }

    @Override
    public void deleteById(Object entity) throws ServiceException {

    }

    @Override
    public void delete(long id) throws ServiceException {
        try {
            taxiOrderDAO.delete();
        } catch (DAOException e) {
            throw new ServiceException("can't delete taxiOrder in service");
        }
    }
}
