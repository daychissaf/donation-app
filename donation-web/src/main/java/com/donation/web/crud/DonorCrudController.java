package com.donation.web.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donation.common.CrudService;
import com.donation.crud.DonorCrudService;
import com.donation.donor.model.Donor;
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

