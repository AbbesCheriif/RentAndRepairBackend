package com.example.batiment.repository;

import com.example.batiment.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findByAddress(String address);
    List<Building> findByType(String type);
    List<Building> findByAreaBetween(double minArea, double maxArea);
    List<Building> findByPriceBetween(double minPrice, double maxPrice);
    List<Building> findByRoomsBetween(int minRooms, int maxRooms);
}
