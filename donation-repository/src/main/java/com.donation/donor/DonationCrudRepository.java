package com.donation.donor;

import com.donation.donor.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationCrudRepository extends JpaRepository<Donation, Long> {
}
