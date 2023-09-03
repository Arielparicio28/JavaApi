package com.example.camperapi.utils;

import com.example.camperapi.dto.ActivityDto;
import com.example.camperapi.dto.CamperWithActivitiesDto;
import com.example.camperapi.entity.Activity;
import com.example.camperapi.entity.Camper;
import com.example.camperapi.entity.SignUp;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CamperMapper extends ModelMapper {
    public CamperMapper() {


        Converter<List<SignUp>, List<ActivityDto>> convertSignups = new AbstractConverter<>() {
            protected List<ActivityDto> convert(List<SignUp> signups) {
                List<ActivityDto> activityDTOs = new ArrayList<>();

                for (SignUp signup : signups) {
                    Activity activity = signup.getActivity();
                    ActivityDto activityDTO = new ActivityDto();
                    activityDTO.setId(activity.getId());
                    activityDTO.setName(activity.getName());
                    activityDTO.setDifficulty(activity.getDifficulty());
                    activityDTOs.add(activityDTO);
                }

                return activityDTOs;
            }
        };

        createTypeMap(Camper.class, CamperWithActivitiesDto.class)
                .addMappings(mapper -> mapper.using(convertSignups)
                        .map(Camper::getSignups, CamperWithActivitiesDto::setActivities));
    }


}