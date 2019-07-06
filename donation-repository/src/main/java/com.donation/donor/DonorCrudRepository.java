package com.donation.donor;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.donor.model.Donor;

@Repository
public interface DonorCrudRepository extends JpaRepository<Donor, Long> {
}
