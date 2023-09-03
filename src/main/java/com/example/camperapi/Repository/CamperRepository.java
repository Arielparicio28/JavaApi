package com.example.camperapi.Repository;

import com.example.camperapi.entity.Camper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamperRepository extends JpaRepository<Camper,Long> {
    boolean existsByUsername(String username);
}
