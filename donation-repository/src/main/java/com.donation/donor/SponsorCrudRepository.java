package com.donation.donor;

import com.donation.donor.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorCrudRepository extends JpaRepository<Sponsor, Long> {


}
