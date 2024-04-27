package com.application.donationmanagementservice.services.impl;

import com.application.donationmanagementservice.common.value.Donation;
import com.application.donationmanagementservice.controllers.dto.DonationViewResponseDTO;
import com.application.donationmanagementservice.external.repository.IDonationRepository;
import com.application.donationmanagementservice.services.IDonationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationService implements IDonationService {
    private final IDonationRepository donationRepository;

    public DonationService(final IDonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public DonationViewResponseDTO donate(final Donation donation) {
        return new DonationViewResponseDTO(donationRepository.persistDonation(donation));
    }

    @Override
    public DonationViewResponseDTO getDonationById(final String donationId) {
        return new DonationViewResponseDTO(donationRepository.getDonationById(donationId));
    }

    @Override
    public List<DonationViewResponseDTO> getAllDonations() {
        return donationRepository.getAllDonations().stream()
                .map(DonationViewResponseDTO::new)
                .collect(Collectors.toList());
    }
}
