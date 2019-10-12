package be.weve.testgenerator.business.repository;

import be.weve.testgenerator.util.exception.NotImplementedException;

import java.util.List;

public interface Repository<T> {

    //create
    T create(T t) throws NotImplementedException;

    //read
    List<T> readAll() throws NotImplementedException;
    T read(int id) throws NotImplementedException;

    //update
    T update(T t) throws NotImplementedException;

    //delete
    boolean delete(T t) throws NotImplementedException;
    boolean delete(int id) throws NotImplementedException;
}
