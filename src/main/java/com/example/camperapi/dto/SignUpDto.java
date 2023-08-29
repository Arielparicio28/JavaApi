package com.example.camperapi.dto;

public class SignUpDto {
    private Long id;
    private int camper_id;
    private int activity_id;
    private int time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCamper_id() {
        return camper_id;
    }

    public void setCamper_id(int camper_id) {
        this.camper_id = camper_id;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
