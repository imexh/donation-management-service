package com.application.donationmanagementservice.services.impl;

import com.application.donationmanagementservice.controllers.dto.PatientViewResponseDTO;
import com.application.donationmanagementservice.external.repository.IPatientRepository;
import com.application.donationmanagementservice.services.IPatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {
    private final IPatientRepository patientRepository;

    public PatientService(final IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientViewResponseDTO> getAllQualifiedPatients() {
        return patientRepository.getAllQualifiedPatients().stream()
                .map(PatientViewResponseDTO::new)
                .collect(Collectors.toList());
    }
}
