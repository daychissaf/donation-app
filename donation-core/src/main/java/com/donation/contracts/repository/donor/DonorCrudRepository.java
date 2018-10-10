package com.donation.contracts.repository.donor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.donation.model.Donor;

@Repository
public interface DonorCrudRepository extends CrudRepository<Donor, Long> {
}
