package com.example.adhar.Service;

import com.example.adhar.Entity.Citizen;
import com.example.adhar.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitizenService {
    @Autowired
    CitizenRepository citizenRepository;

    public Citizen addCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public Citizen getCitizenByAadhaarNo(String aadhaarNo) throws ChangeSetPersister.NotFoundException{
        return citizenRepository.findByAadhaarNo(aadhaarNo)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

    }

    public Citizen getCitizenByPan(String pan) throws ChangeSetPersister.NotFoundException {
        return citizenRepository.findByPan(pan)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Citizen updateCitizenNameByAadhaarNo(String aadhaarNo, String newName) throws ChangeSetPersister.NotFoundException {
        Citizen citizen = getCitizenByAadhaarNo(aadhaarNo);
        citizen.setName(newName);
        return citizenRepository.save(citizen);
    }
}
