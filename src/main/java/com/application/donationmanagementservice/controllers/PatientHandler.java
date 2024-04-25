package com.application.donationmanagementservice.controllers;

import com.application.donationmanagementservice.controllers.dto.PatientViewResponseDTO;
import com.application.donationmanagementservice.services.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PatientHandler {
    private final IPatientService patientService;

    public PatientHandler(final IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/qualified/patients")
    public ResponseEntity<List<PatientViewResponseDTO>> getAllQualifiedPatients() {
        return new ResponseEntity<>(this.patientService.getAllQualifiedPatients(), HttpStatus.OK);
    }
}
