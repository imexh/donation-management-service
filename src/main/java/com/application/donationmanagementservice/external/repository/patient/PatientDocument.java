package com.application.donationmanagementservice.external.repository.patient;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "patients")
public class PatientDocument {
    @NotNull
    @Id
    String id;

    @NotNull
    @Field(name = "name")
    String name;

    @NotNull
    @Field(name = "birth_date")
    String birthDate;

    @NotNull
    @Field(name = "email")
    String email;

    @NotNull
    @Field(name = "income")
    String income;

    @NotNull
    @Field(name = "contact")
    String contact;

    @NotNull
    @Field(name = "is_qualified")
    boolean isQualified;
}
