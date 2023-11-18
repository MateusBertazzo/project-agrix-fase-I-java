package com.betrybe.agrix.services;

import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }
  
  public List<Farm> getAllFarm() {
    return farmRepository.findAll();
  }


  /**
   * Get farm by id.
   */
  public Farm getFarmById(Long id) {
    // return farmRepository.findById(id)
    //     .orElseThrow(() -> new FarmNotFoundException("Fazenda não encontrada!"));
    Optional<Farm> farm = farmRepository.findById(id);
    if (farm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    return farm.get();
  }
}
