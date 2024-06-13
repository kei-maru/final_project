package com.example.project.repository;

import com.example.project.model.BusinessObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessObjectRepository extends JpaRepository<BusinessObject, Long> {
    List<BusinessObject> findByName(String name);
}
