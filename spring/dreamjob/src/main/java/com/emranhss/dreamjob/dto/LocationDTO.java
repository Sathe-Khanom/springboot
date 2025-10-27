package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Category;
import com.emranhss.dreamjob.entity.Location;

public class LocationDTO {

    private Long id;
    private String name;

    public LocationDTO() {}

    public LocationDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
