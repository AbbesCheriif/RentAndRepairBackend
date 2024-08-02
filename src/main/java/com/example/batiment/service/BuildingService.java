package com.example.batiment.service;

import com.example.batiment.model.Building;
import com.example.batiment.repository.BuildingRepository;
import com.example.batiment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public Building getBuildingById(Long id) {
        return buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found with id " + id));
    }

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building updateBuilding(Long id, Building buildingDetails) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found with id " + id));

        building.setType(buildingDetails.getType());
        building.setAddress(buildingDetails.getAddress());
        building.setRooms(buildingDetails.getRooms());
        building.setPrice(buildingDetails.getPrice());
        building.setArea(buildingDetails.getArea());

        return buildingRepository.save(building);
    }

    public void deleteBuilding(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found with id " + id));
        buildingRepository.delete(building);
    }

    // section pour chercher les âtiments selon un paramètre ( sauf l'id )

    public List<Building> getBuildingsByAddress(String address) {
        return buildingRepository.findByAddress(address);
    }

    public List<Building> getBuildingsByType(String type) {
        return buildingRepository.findByType(type);
    }

    public List<Building> getBuildingsByAreaBetween(double minArea, double maxArea) {
        return buildingRepository.findByAreaBetween(minArea, maxArea);
    }

    public List<Building> getBuildingsByPriceBetween(double minPrice, double maxPrice) {
        return buildingRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Building> getBuildingsByRoomsBetween(int minRooms, int maxRooms) {
        return buildingRepository.findByRoomsBetween(minRooms, maxRooms);
    }

}
