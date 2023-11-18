package com.betrybe.agrix.models.entities;


import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  @Column(name = "planted_area")
  private Double plantedArea;

  public Crop() {
  }

  public Crop(Long id, String name, Farm farm, Double plantedArea) {
    this.id = id;
    this.name = name;
    this.farm = farm;
    this.plantedArea = plantedArea;
  }
}
