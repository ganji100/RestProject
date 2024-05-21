package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.model.Registration;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
