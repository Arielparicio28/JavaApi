package com.example.camperapi.Service;

import com.example.camperapi.Repository.CamperRepository;
import com.example.camperapi.Repository.SignUpRepository;
import com.example.camperapi.dto.CamperResponseDto;
import com.example.camperapi.dto.CamperWithActivitiesDto;
import com.example.camperapi.entity.Camper;
import com.example.camperapi.utils.CamperMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.camperapi.dto.CamperDto;
import java.util.List;
import jakarta.persistence.EntityExistsException;
@Service
public class CamperService {

    private final CamperRepository camperRepository;
    private final SignUpRepository signupRepository;
    private final CamperMapper camperMapper;

    @Autowired
    public CamperService(CamperRepository camperRepository, SignUpRepository signupRepository, CamperMapper camperMapper) {
        this.camperRepository = camperRepository;
        this.signupRepository = signupRepository;
        this.camperMapper = camperMapper;
    }

    public CamperResponseDto createCamper(CamperDto camperCreateDTO) {

        if (camperRepository.existsByUsername(camperCreateDTO.getUsername())) {
            throw new EntityExistsException("Camper with username " + camperCreateDTO.getUsername() + " already exists.");
        }

        Camper camper = new Camper(
                camperCreateDTO.getName(),
                camperCreateDTO.getAge(),
                camperCreateDTO.getUsername(),
                camperCreateDTO.getPassword()
        );

        Camper createdCamper = camperRepository.save(camper);
        return convertToResponseDto(createdCamper);
    }



    public List<Camper> getAllCampers() {
        List<Camper> campers = camperRepository.findAll();
        if (campers.isEmpty()) {
            throw new EntityNotFoundException("No campers found.");
        }
        return campers;
    }


    public CamperWithActivitiesDto getCamperWithActivitiesAndSignupsById(Long id) {
        Camper camper = camperRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camper with ID " + id + " not found."));

        var camperReturn = camperMapper.map(camper, CamperWithActivitiesDto.class);
        return camperReturn;
    }

    private CamperResponseDto convertToResponseDto(Camper camper) {
        return camperMapper.map(camper, CamperResponseDto.class);
    }

}
