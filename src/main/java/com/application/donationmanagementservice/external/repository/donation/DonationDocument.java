package com.application.donationmanagementservice.external.repository.donation;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "donations")
public class DonationDocument {
    @NotNull
    @Id
    String id;

    @NotNull
    @Field(name = "philanthropist_id")
    String philanthropistId;

    @NotNull
    @Field(name = "patient_id")
    String patientId;

    @NotNull
    @Field(name = "donation_date")
    String donationDate;

    @NotNull
    @Field(name = "donation_amount")
    Double donationAmount;
}
