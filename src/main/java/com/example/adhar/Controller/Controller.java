package com.example.adhar.Controller;


import com.example.adhar.Entity.Citizen;
import com.example.adhar.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/add")
public class Controller {
    @Autowired
    private CitizenService citizenService;

    @PostMapping("/citizen")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        Citizen newCitizen = citizenService.addCitizen(citizen);
        return new ResponseEntity<>(newCitizen, HttpStatus.CREATED);
    }

    @GetMapping("/{aadhaarNo}")
    public ResponseEntity<Citizen> getCitizenByAadhaarNo(@PathVariable String aadhaarNo) throws ChangeSetPersister.NotFoundException{
        Citizen citizen = citizenService.getCitizenByAadhaarNo(aadhaarNo);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }

    @GetMapping("/pan/{pan}")
    public ResponseEntity<Citizen> getCitizenByPan(@PathVariable String pan) throws ChangeSetPersister.NotFoundException {
        Citizen citizen = citizenService.getCitizenByPan(pan);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }

    @PutMapping("/{aadhaarNo}")
    public ResponseEntity<Citizen> updateCitizenNameByAadhaarNo(
            @PathVariable String aadhaarNo,
            @RequestParam String newName) throws ChangeSetPersister.NotFoundException {
        Citizen updatedCitizen = citizenService.updateCitizenNameByAadhaarNo(aadhaarNo, newName);
        return new ResponseEntity<>(updatedCitizen, HttpStatus.OK);
    }
}
