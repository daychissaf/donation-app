package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.DonorCrudService;
import com.donation.donor.DonorCrudRepository;
import com.donation.donor.model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DonorCrudServiceImpl extends CrudServiceImpl<Donor> implements DonorCrudService {

    @Autowired
    private DonorCrudRepository donorCrudRepository;

    @Override
    protected CrudRepository<Donor, Long> repository() {
        return donorCrudRepository;
    }
}
