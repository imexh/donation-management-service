package com.application.donationmanagementservice.services;

import com.application.donationmanagementservice.common.value.Donation;
import com.application.donationmanagementservice.controllers.dto.DonationViewResponseDTO;

import java.util.List;

public interface IDonationService {
    DonationViewResponseDTO donate(final Donation donation);

    DonationViewResponseDTO getDonationById(final String donationId);

    List<DonationViewResponseDTO> getAllDonations();
}
