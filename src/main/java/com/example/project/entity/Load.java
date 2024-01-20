package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="load")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private String weight;
    private String comment;
    private String shipperId;
    private String date;

}