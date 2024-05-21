package com.kani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.model.Registration;
import com.kani.repo.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registerRepo;

	public void registerCustomer(Registration registration) {

		registerRepo.save(registration);
	}

	public List<Registration> getAllCustomers() {
		return registerRepo.findAll();
	}

	public void updateCustomer(Registration registration) {

		Long registerId = registration.getId();
		Registration reg = registerRepo.findById(registerId).get();

		registration.setFirstName(reg.getFirstName());
		registration.setLastName(reg.getLastName());
		registration.setEmail(reg.getEmail());
		registration.setPassword(reg.getPassword());
		registration.setMobileNumber(reg.getMobileNumber());
		registerRepo.save(registration);
	}

	public void deleteCustomerById(long id) {
		registerRepo.deleteById(id);
	}
}
