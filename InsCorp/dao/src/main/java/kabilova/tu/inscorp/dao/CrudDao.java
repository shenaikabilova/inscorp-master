package kabilova.tu.inscorp.dao;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public interface CrudDao<T> {
    void create (T t);
    List<T> read();
    void update(T t);
    void delete(T t);
}
