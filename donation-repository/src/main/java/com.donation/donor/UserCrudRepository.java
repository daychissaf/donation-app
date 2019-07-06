package com.donation.donor;

import com.donation.donor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<User, Long> {



}
