package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.SponsorCrudService;
import com.donation.donor.model.Association;
import com.donation.donor.model.Sponsor;
import com.donation.web.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
