package com.example.project.service;


import com.example.project.entity.Load;

import java.util.List;
import java.util.Optional;

public interface LoadService {

    public Load createLoad(Load load);

    Boolean deleteLoad(Long id);

    Optional<Load> findloadById(Long id);

    Load updateLoad(Long id ,Load load);

    List<Load> findLoadbyShipperId(String shipperId);

}
