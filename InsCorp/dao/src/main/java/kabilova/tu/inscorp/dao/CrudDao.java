package kabilova.tu.inscorp.dao;

import exception.InsCorpException;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface CrudDao<T> {
    void create (T t) throws InsCorpException;
    List read();
    void update(T t);
    void delete(T t);
}
