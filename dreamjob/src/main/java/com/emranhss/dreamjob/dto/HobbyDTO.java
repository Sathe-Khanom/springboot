package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Hobby;

public class HobbyDTO {
    private Long id;
    private String name;

    public HobbyDTO(Hobby hobby) {
        this.id = hobby.getId();
        this.name = hobby.getName();

    }
}
