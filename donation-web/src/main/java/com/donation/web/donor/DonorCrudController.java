package com.donation.web.donor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donation.common.CrudService;
import com.donation.donor.DonorCrudService;
import com.donation.model.Donor;
import com.donation.web.common.CrudController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/donors")
public class DonorCrudController extends CrudController<Donor> {

    @Autowired
    private DonorCrudService donorService;

    @Override
    public CrudService<Donor> service() {
        return this.donorService;
    }
}

