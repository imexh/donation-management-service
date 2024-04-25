package com.application.donationmanagementservice.external.repository.patient;

import com.application.donationmanagementservice.common.value.Patient;
import com.application.donationmanagementservice.external.repository.IPatientRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryAdapter implements IPatientRepository {
    private final MongoTemplate mongoTemplate;

    public PatientRepositoryAdapter(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Patient getPatientById(final String identity) {
        final PatientDocument patientDocument = mongoTemplate.findById(identity, PatientDocument.class);

        return patientDocument != null ? PatientModelMapper.toPatient(patientDocument) : null;
    }

    @Override
    public List<Patient> getAllQualifiedPatients() {
        List<PatientDocument> patientDocuments = mongoTemplate.findAll(PatientDocument.class);

        patientDocuments.removeIf(patientDocument -> !patientDocument.isQualified);

        return PatientModelMapper.toPatientList(patientDocuments);
    }
}
