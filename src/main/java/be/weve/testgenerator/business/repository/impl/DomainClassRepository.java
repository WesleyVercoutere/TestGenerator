package be.weve.testgenerator.business.repository.impl;

import be.weve.testgenerator.business.DomainClass;
import be.weve.testgenerator.business.repository.Repository;
import be.weve.testgenerator.util.exception.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class DomainClassRepository implements Repository<DomainClass> {

    List<DomainClass> domainClasses;

    public DomainClassRepository() {
        domainClasses = new ArrayList<>();
    }

    @Override
    public DomainClass create(DomainClass domainClass) {
        domainClasses.add(domainClass);

        return domainClass;
    }

    @Override
    public List<DomainClass> readAll() {
        return domainClasses;
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
