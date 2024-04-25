package com.application.donationmanagementservice.services;


import com.application.donationmanagementservice.controllers.dto.PatientViewResponseDTO;

import java.util.List;

public interface IPatientService {
    List<PatientViewResponseDTO> getAllQualifiedPatients();
}
