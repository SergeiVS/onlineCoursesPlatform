package repository;

import java.util.List;

public interface RepositoryInterface <T> {
    Integer add(T obj);
    List<T> findAll();
    List<T> findById(Integer id);
    List<T> findByName(String name);


}
