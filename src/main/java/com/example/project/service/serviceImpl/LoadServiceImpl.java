package com.example.project.service.serviceImpl;

import com.example.project.entity.Load;
import com.example.project.repository.LoadRepository;
import com.example.project.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public Boolean deleteLoad(Long loadId) {
        Load load = loadRepository.findById(loadId).orElse(null);
        if (load != null) {
            loadRepository.delete(load);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Load> findloadById(Long id) {
        Optional<Load> load = loadRepository.findById(id);
        if(load.isPresent()){
            return loadRepository.findById(id);
        }
        return null;
    }

    @Override
    public Load updateLoad(Long loadId, Load updatedLoad) {

        Load existingLoad = loadRepository.findById(loadId).orElse(null);

        if (existingLoad != null) {
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setShipperId(updatedLoad.getShipperId());
            existingLoad.setDate(updatedLoad.getDate());
        }

        return loadRepository.save(existingLoad);
    }

    @Override
    public List<Load> findLoadbyShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }
}
