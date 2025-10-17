package com.java.apifirst.openapiimpl.dao;

import com.java.apifirst.model.GetAllProducts200ResponseInner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    List<GetAllProducts200ResponseInner> savedProductList = new ArrayList<>();
    @Override
    public <S extends GetAllProducts200ResponseInner> S save(S entity) {
        savedProductList.add(entity);
        return entity;
    }

    @Override
    public <S extends GetAllProducts200ResponseInner> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<GetAllProducts200ResponseInner> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<GetAllProducts200ResponseInner> findAll() {
        return savedProductList;
    }

    @Override
    public Iterable<GetAllProducts200ResponseInner> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(GetAllProducts200ResponseInner entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends GetAllProducts200ResponseInner> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
