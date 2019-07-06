package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.SponsorCrudService;
import com.donation.donor.model.Sponsor;
import com.donation.web.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/sponsors")
public class SponsorCrudController extends CrudController<Sponsor> {

    @Autowired
    private SponsorCrudService sponsorService;

    @Override
    public CrudService<Sponsor> service() {
        return this.sponsorService;
    }
}
