package ru.manannikov.learnMVC.generic;

import java.util.List;

public interface GenericService<T> {
    T create(T t);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
}
