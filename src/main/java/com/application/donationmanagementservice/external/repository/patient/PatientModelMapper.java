package com.application.donationmanagementservice.external.repository.patient;

import com.application.donationmanagementservice.common.value.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientModelMapper {
    public PatientModelMapper() {
    }

    static PatientDocument toDocument(final Patient patient) {
        PatientDocument patientDocument = new PatientDocument();

        patientDocument.id = patient.getId();
        patientDocument.name = patient.getName();
        patientDocument.email = patient.getEmail();
        patientDocument.birthDate = patient.getBirthDate();
        patientDocument.income = patient.getIncome();
        patientDocument.contact = patient.getContact();

        return patientDocument;
    }

    static Patient toPatient(final PatientDocument patientDocument) {
        return new Patient(patientDocument.id, patientDocument.name, patientDocument.email, patientDocument.birthDate,
                patientDocument.income, patientDocument.contact);
    }

    static List<Patient> toPatientList(final List<PatientDocument> patientDocuments) {
        return patientDocuments.stream().map(PatientModelMapper::toPatient).collect(Collectors.toList());
    }
}
