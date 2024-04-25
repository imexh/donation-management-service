package com.application.donationmanagementservice.controllers;

import com.application.donationmanagementservice.controllers.dto.DonationViewResponseDTO;
import com.application.donationmanagementservice.controllers.dto.MakeDonationRequestDTO;
import com.application.donationmanagementservice.services.IDonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DonationHandler {
    private final IDonationService donationService;

    public DonationHandler(final IDonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/donations")
    public ResponseEntity<List<DonationViewResponseDTO>> getAllDonations() {
        return new ResponseEntity<>(this.donationService.getAllDonations(), HttpStatus.OK);
    }

    @GetMapping("/donations/{donationId}")
    public ResponseEntity<DonationViewResponseDTO> getDonationById(
            @PathVariable String donationId) {
        return new ResponseEntity<>(this.donationService.getDonationById(donationId), HttpStatus.OK);
    }

    @PostMapping("/donations")
    public ResponseEntity<DonationViewResponseDTO> donate(
            @RequestBody MakeDonationRequestDTO requestDTO) {
        return new ResponseEntity<>(this.donationService.donate(requestDTO.toDonation()), HttpStatus.CREATED);
    }
}
