package com.donation.web;

import com.donation.crud.SponsorCrudService;
import com.donation.donor.model.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/sponsor")
@RestController

public class SponsorController {

    @Autowired
    private SponsorCrudService sponsorCrudService;

    @GetMapping
    public List<Sponsor> getSponsors() {
        return sponsorCrudService.getAll();
    }

}
