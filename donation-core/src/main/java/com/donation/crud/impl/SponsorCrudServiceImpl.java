package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.SponsorCrudService;
import com.donation.donor.SponsorCrudRepository;
import com.donation.donor.model.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SponsorCrudServiceImpl extends CrudServiceImpl<Sponsor> implements SponsorCrudService {

    @Autowired
    private SponsorCrudRepository sponsorRepository;

    @Override protected CrudRepository<Sponsor, Long> repository() {
        return sponsorRepository;
    }
}
