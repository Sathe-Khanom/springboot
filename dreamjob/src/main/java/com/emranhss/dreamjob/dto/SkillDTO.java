package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Skill;

public class SkillDTO {

    private Long id;
    private String name;
    private String level;


    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.level = skill.getLevel();



    }
}
