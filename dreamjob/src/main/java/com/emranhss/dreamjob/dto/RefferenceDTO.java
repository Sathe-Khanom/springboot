package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Refference;

public class RefferenceDTO {

    private Long id;
    private String name;
    private String contact;
    private String relation;

  public  RefferenceDTO(Refference refference){
      this.id = refference.getId();
      this.name = refference.getName();
      this.contact = refference.getContact();
      this.relation = refference.getRelation();


  }

}
