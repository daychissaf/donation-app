package com.donation.donor;

import com.donation.donor.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorCrudRepository extends JpaRepository<Donor, Long> {
}
