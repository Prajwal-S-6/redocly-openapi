package com.java.apifirst.openapiimpl.dao;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
@AllArgsConstructor
@Data
public class CustomerRepositoryImpl implements CustomerRepository{

    List<GetAllCustomers200ResponseInner> customersList = new ArrayList<>();

    @Override
    public <S extends GetAllCustomers200ResponseInner> S save(S entity) {
        customersList.add(entity);
        return entity;
    }

    @Override
    public <S extends GetAllCustomers200ResponseInner> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<GetAllCustomers200ResponseInner> findById(UUID uuid) {
        return customersList.stream()
                .filter(customer -> uuid.equals(customer.getId()))
                .findFirst();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<GetAllCustomers200ResponseInner> findAll() {
        return customersList;
    }

    @Override
    public Iterable<GetAllCustomers200ResponseInner> findAllById(Iterable<UUID> uuids) {
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
    public void delete(GetAllCustomers200ResponseInner entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends GetAllCustomers200ResponseInner> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
