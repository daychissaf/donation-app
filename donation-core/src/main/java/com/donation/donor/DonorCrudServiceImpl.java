package com.donation.donor;

import org.springframework.stereotype.Service;

import com.donation.common.CrudServiceImpl;
import com.donation.model.Donor;

@Service
public class DonorCrudServiceImpl extends CrudServiceImpl<Donor> implements DonorCrudService {

}
