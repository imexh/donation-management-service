package com.application.donationmanagementservice.external.repository;

import com.application.donationmanagementservice.common.value.Donation;

import java.util.List;

public interface IDonationRepository {
    Donation persistDonation(final Donation donation);

    Donation getDonationById(final String identity);

    List<Donation> getAllDonations();
}
