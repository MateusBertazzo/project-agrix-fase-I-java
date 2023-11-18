// package com.betrybe.agrix.services;


// import com.betrybe.agrix.models.entities.Crop;
// import com.betrybe.agrix.models.entities.Farm;
// import com.betrybe.agrix.models.repositories.CropRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// /**
//  * Crop service.
//  */
// @Service
// public class CropService {
//   private final CropRepository cropRepository;
//   private final FarmService farmService;
  
//   @Autowired
//   public CropService(CropRepository cropRepository, FarmService farmService) {
//     this.cropRepository = cropRepository;
//     this.farmService = farmService;
//   }

//   /**
//   * Create crop.
//   */
//   public Crop createCrop(Crop crop, Long farmId) {
//     Farm farm = farmService.getFarmById(farmId);
//     crop.setFarm(farm);
//     Crop insertCrop = cropRepository.save(crop);    
//     return insertCrop;
//   }
// }
