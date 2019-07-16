package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.AssociationCrudService;
import com.donation.donor.AssociationCrudRepository;
import com.donation.donor.model.Association;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociationCrudServiceImpl extends CrudServiceImpl<Association> implements AssociationCrudService {

    @Autowired
    private AssociationCrudRepository associationRepository;

    @Override
    protected CrudRepository<Association, Long> repository() {
        return associationRepository;
    }
}
