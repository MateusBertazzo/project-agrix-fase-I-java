package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
// import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  // private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
    // this.cropService = cropService;
  }

  /**
   * Create a farm.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.createFarm(farmDto.toFarm());

    FarmDto farmDtoResponse = new FarmDto(farm.getId(), farm.getName(), farm.getSize());

    return farmDtoResponse;
  }

  /**
   * Get all farms.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FarmDto> getAllFarm() {
    List<Farm> farms = farmService.getAllFarm();
    List<FarmDto> farmsDto = farms.stream()
        .map(farm -> new FarmDto(farm.getId(), farm.getName(), farm.getSize())).toList();

    return farmsDto;
  }

  /**
   * Get farm by id.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FarmDto getFarmById(@PathVariable Long id) {
    Farm farm = farmService.getFarmById(id);
    FarmDto farmDto = new FarmDto(farm.getId(), farm.getName(), farm.getSize());

    return farmDto;
  }


  // @PostMapping("/{farmId}/crops")
  // @ResponseStatus(HttpStatus.CREATED)
  // public Crop createCrop(@PathVariable Long farmId, @RequestBody Crop crop) {
  //   return cropService.createCrop(crop, farmId);    
  // }
}
