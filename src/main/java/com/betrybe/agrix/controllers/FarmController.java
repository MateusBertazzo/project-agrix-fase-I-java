package com.betrybe.agrix.controllers;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
 * Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody Farm farm) {
    return farmService.createFarm(farm);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Farm> getAllFarm() {
    return farmService.getAllFarm();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Farm getFarmById(Long id) {
    return farmService.getFarmById(id);
  }
}
