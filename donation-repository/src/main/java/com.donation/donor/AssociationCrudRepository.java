package com.donation.donor;

import com.donation.donor.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationCrudRepository extends JpaRepository<Association, Long> {

}
