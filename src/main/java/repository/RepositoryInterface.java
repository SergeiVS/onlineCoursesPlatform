package repository;

import java.util.List;

public interface RepositoryInterface <T> {
    List<T> objList();
    void add(T obj);
    void update(T obj);
    List<T> findAll();
    List<T> findById(Integer id);
    List<T> findByName(String name);

}