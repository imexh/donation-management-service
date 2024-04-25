package com.application.donationmanagementservice.external.repository.donation;

import com.application.donationmanagementservice.common.value.Donation;
import com.application.donationmanagementservice.external.repository.IDonationRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class DonationRepositoryAdapter implements IDonationRepository {
    private final MongoTemplate mongoTemplate;

    public DonationRepositoryAdapter(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Donation persistDonation(final Donation donation) {
        Objects.requireNonNull(donation, "Donation repository required non null patient, got null.");

        DonationDocument donationDocument = DonationModelMapper.toDocument(donation);

        return DonationModelMapper.toDonation(mongoTemplate.save(donationDocument));
    }

    @Override
    public Donation getDonationById(final String identity) {
        final DonationDocument donationDocument = mongoTemplate.findById(identity, DonationDocument.class);

        return donationDocument != null ? DonationModelMapper.toDonation(donationDocument) : null;
    }

    @Override
    public List<Donation> getAllDonations() {
        List<DonationDocument> donationDocuments = mongoTemplate.findAll(DonationDocument.class);
        return DonationModelMapper.toDonationList(donationDocuments);
    }
}
