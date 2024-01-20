package com.example.project.controller;

import com.example.project.entity.Load;
import com.example.project.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;


    @PostMapping
    public ResponseEntity<?> addLoad(@RequestBody Load load) {

        return new ResponseEntity<>(loadService.createLoad(load), HttpStatus.CREATED);
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<?> updateLoad(@PathVariable Long loadId, @RequestBody Load load) {
        try {
            Load load1 = loadService.updateLoad(loadId, load);
            return ResponseEntity.status(HttpStatus.CREATED).body(load1);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() +" with id: " + loadId);
        }
    }


    @GetMapping
    public ResponseEntity<List<Load>> getLoads(@RequestParam String shipperId) {


        List<Load> loadList = loadService.findLoadbyShipperId(shipperId);
        return new ResponseEntity<>(loadList, HttpStatus.OK);
    }


    @GetMapping("/{loadId}")
    public ResponseEntity<?> getLoad(@PathVariable Long loadId) {

        try{
            Optional<Load> load = loadService.findloadById(loadId);
            if(load.isPresent()){
                return new ResponseEntity<>(load, HttpStatus.OK);
            }
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + " with id: " + loadId);
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/{loadId}")
    public ResponseEntity<?> deleteLoad(@PathVariable Long loadId) {

        Boolean flag = loadService.deleteLoad(loadId);
        if (flag != false) {

            return ResponseEntity.ok("Load deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Load with ID " + loadId + " not found");
        }
    }
}
