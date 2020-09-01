package com.wellsfargo.sectorservice.service;

import com.wellsfargo.sectorservice.models.Sector;

import org.springframework.data.repository.CrudRepository;

public interface SectorRepository extends CrudRepository<Sector, Integer> {
    
}