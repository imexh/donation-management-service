package com.application.donationmanagementservice.external.repository;

import com.application.donationmanagementservice.common.value.Patient;

import java.util.List;

public interface IPatientRepository {
    Patient getPatientById(final String identity);

    List<Patient> getAllQualifiedPatients();
}
