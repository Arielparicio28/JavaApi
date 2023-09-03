package com.example.camperapi.Controller;


import com.example.camperapi.Repository.CamperRepository;
import com.example.camperapi.Service.CamperService;
import com.example.camperapi.dto.CamperDto;
import com.example.camperapi.dto.CamperResponseDto;
import com.example.camperapi.dto.CamperWithActivitiesDto;
import com.example.camperapi.entity.Camper;
import com.example.camperapi.utils.CamperMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CamperController {

    private final CamperService camperService;
    private final CamperRepository camperRepository;
    private final CamperMapper mapper;

    @Autowired
    public CamperController(CamperService camperService, CamperMapper mapper, CamperRepository camperRepository) {
        this.camperService = camperService;
        this.mapper = mapper;
        this.camperRepository = camperRepository;
    }

    @PostMapping("/camper")
    public ResponseEntity<CamperResponseDto> createCamper(@Valid @RequestBody CamperDto camperCreateDTO) {
        CamperResponseDto createdCamper = camperService.createCamper(camperCreateDTO);
        return ResponseEntity.ok().body(createdCamper);
    }

    @GetMapping("/camper/{id}")
    public ResponseEntity<CamperWithActivitiesDto> getCamperById(@PathVariable Long id) {
        CamperWithActivitiesDto responseDTO = camperService.getCamperWithActivitiesAndSignupsById(id);
        return ResponseEntity.ok().body(responseDTO);
    }



    @GetMapping("/campers")
    public ResponseEntity<List<CamperResponseDto>> getAllCampers() {
        List<Camper> allCampers = camperService.getAllCampers();
        List<CamperResponseDto> responseDTOs = allCampers.stream()
                .map(camper -> mapper.map(camper, CamperResponseDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responseDTOs);
    }

    private CamperResponseDto convertToResponseDto(Camper camper) {
        CamperResponseDto camperResponseDTO = mapper.map(camper, CamperResponseDto.class);

        return camperResponseDTO;
    }

    public CamperWithActivitiesDto getCamperWithActivitiesAndSignupsById(Long id) {
        Camper camper = camperRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camper with ID " + id + " not found."));

        return mapper.map(camper, CamperWithActivitiesDto.class);
    }


}
