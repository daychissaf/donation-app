package com.donation.donor;

import com.donation.donor.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectCrudRepository extends JpaRepository<Project, Long> {
}
