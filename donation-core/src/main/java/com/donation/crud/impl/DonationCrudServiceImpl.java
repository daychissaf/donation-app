package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.DonationCrudService;
import com.donation.donor.DonationCrudRepository;
import com.donation.donor.model.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationCrudServiceImpl extends CrudServiceImpl<Donation> implements DonationCrudService {

   @Autowired
   private DonationCrudRepository donorCrudRepository;

   @Override
   protected CrudRepository<Donation, Long> repository() {
      return donorCrudRepository;
   }
}
