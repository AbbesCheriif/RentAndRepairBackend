package com.example.batiment.controller;

import com.example.batiment.model.Building;
import com.example.batiment.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Building building) {
        return ResponseEntity.ok(buildingService.createBuilding(building));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.getBuildingById(id));
    }

    @GetMapping
    public ResponseEntity<List<Building>> getAllBuildings() {
        return ResponseEntity.ok(buildingService.getAllBuildings());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Building> updateBuilding(@PathVariable Long id, @RequestBody Building buildingDetails) {
        return ResponseEntity.ok(buildingService.updateBuilding(id, buildingDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/address")
    public ResponseEntity<List<Building>> getBuildingsByAddress(@RequestParam String address) {
        return ResponseEntity.ok(buildingService.getBuildingsByAddress(address));
    }

    @GetMapping("/type")
    public ResponseEntity<List<Building>> getBuildingsByType(@RequestParam String type) {
        return ResponseEntity.ok(buildingService.getBuildingsByType(type));
    }

    @GetMapping("/area")
    public ResponseEntity<List<Building>> getBuildingsByAreaBetween(@RequestParam double minArea, @RequestParam double maxArea) {
        return ResponseEntity.ok(buildingService.getBuildingsByAreaBetween(minArea, maxArea));
    }

    @GetMapping("/price")
    public ResponseEntity<List<Building>> getBuildingsByPriceBetween(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return ResponseEntity.ok(buildingService.getBuildingsByPriceBetween(minPrice, maxPrice));
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Building>> getBuildingsByRoomsBetween(@RequestParam int minRooms, @RequestParam int maxRooms) {
        return ResponseEntity.ok(buildingService.getBuildingsByRoomsBetween(minRooms, maxRooms));
    }
}
