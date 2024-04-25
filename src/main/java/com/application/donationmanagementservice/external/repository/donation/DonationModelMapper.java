package com.application.donationmanagementservice.external.repository.donation;

import com.application.donationmanagementservice.common.value.Donation;

import java.util.List;
import java.util.stream.Collectors;

public class DonationModelMapper {
    public DonationModelMapper() {
    }

    static DonationDocument toDocument(final Donation donation) {
        DonationDocument donationDocument = new DonationDocument();

        donationDocument.id = donation.getId();
        donationDocument.patientId = donation.getPatientId();
        donationDocument.philanthropistId = donation.getPhilanthropistId();
        donationDocument.donationDate = donation.getDonationDate();
        donationDocument.donationAmount = donation.getDonationAmount();

        return donationDocument;
    }

    static Donation toDonation(final DonationDocument donationDocument) {
        return new Donation(donationDocument.id, donationDocument.philanthropistId, donationDocument.patientId,
                donationDocument.donationDate, donationDocument.donationAmount);
    }

    static List<Donation> toDonationList(final List<DonationDocument> donationDocuments) {
        return donationDocuments.stream().map(DonationModelMapper::toDonation).collect(Collectors.toList());
    }
}
