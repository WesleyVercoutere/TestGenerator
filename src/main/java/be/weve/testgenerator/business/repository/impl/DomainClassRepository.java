package be.weve.testgenerator.business.repository.impl;

import be.weve.testgenerator.business.DomainClass;
import be.weve.testgenerator.business.repository.Repository;
import be.weve.testgenerator.util.exception.NotImplementedException;

import java.util.List;

public class DomainClassRepository implements Repository<DomainClass> {

    @Override
    public DomainClass create(DomainClass domainClass) throws NotImplementedException {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public List<DomainClass> readAll() throws NotImplementedException {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public DomainClass read(int id) throws NotImplementedException {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public DomainClass update(DomainClass domainClass) throws NotImplementedException {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public boolean delete(DomainClass domainClass) throws NotImplementedException {
        throw new NotImplementedException("Method not implemented");
    }

    @Override
    public boolean delete(int id) throws NotImplementedException {
        throw new NotImplementedException("Method not implemented");
    }
}
