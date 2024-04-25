package com.application.donationmanagementservice.controllers.dto;

import com.application.donationmanagementservice.common.value.Donation;

public record MakeDonationRequestDTO(String philanthropistId, String patientId, String donationDate,
                                     String donationAmount) {
    public Donation toDonation() {
        return new Donation(null, philanthropistId, patientId, donationDate, Double.parseDouble(donationAmount));
    }
}
