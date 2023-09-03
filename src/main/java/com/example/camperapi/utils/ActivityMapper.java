package com.example.camperapi.utils;

import com.example.camperapi.dto.ActivityDto;
import com.example.camperapi.entity.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    private final ModelMapper modelMapper;

    public ActivityMapper() {
        this.modelMapper = new ModelMapper();
    }

    public ActivityDto toDTO(Activity activity) {
        return modelMapper.map(activity, ActivityDto.class);
    }

    public Activity fromDTO(ActivityDto activityDto) {
        return modelMapper.map(activityDto, Activity.class);
    }
}
