package com.example.project.service;

import com.example.project.model.BusinessObject;
import com.example.project.repository.BusinessObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessObjectService {
    @Autowired
    private BusinessObjectRepository repository;

    public BusinessObject save(BusinessObject obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BusinessObject update(BusinessObject obj) {
        return repository.save(obj);
    }

    public List<BusinessObject> findAll() {
        return repository.findAll();
    }

    public List<BusinessObject> findByName(String name) {
        return repository.findByName(name);
    }

    public BusinessObject findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
