package com.example.adhar.Repository;

import com.example.adhar.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Integer>{
    Optional<Citizen> findByAadhaarNo(String aadhaarNo);
    Optional<Citizen> findByPan(String pan);
}
