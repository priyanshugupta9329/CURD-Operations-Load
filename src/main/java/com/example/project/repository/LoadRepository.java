package com.example.project.repository;

import com.example.project.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {

    List<Load> findByShipperId(String shipperId);
}
