package com.donation.donor;

import com.donation.donor.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoCrudRepository extends JpaRepository<Video, Long> {
}
