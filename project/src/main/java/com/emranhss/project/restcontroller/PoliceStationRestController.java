package com.emranhss.project.restcontroller;


import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.service.PoliceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policestation/")
public class PoliceStationRestController {

 @Autowired
    public PoliceStationService policeStationService;

@PostMapping("")
    public void save (@RequestBody PoliceStation ps){
    policeStationService.saveOrUpdate(ps);
}
@GetMapping("")
    public List<PoliceStation> getAll(){
    return policeStationService.findAll();
}

    @GetMapping("{id}")
    public Optional<PoliceStation> getById(@PathVariable Integer id) {

        return policeStationService.findById(id);
    }

@DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
    policeStationService.deleteById(id);
}
@PutMapping("{id}")
    public void Update(@RequestBody PoliceStation ps){
    policeStationService.saveOrUpdate(ps);
}

}
