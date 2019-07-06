package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.AssociationCrudService;
import com.donation.donor.model.Association;
import com.donation.web.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/associations")
public class AssociationCrudController extends CrudController<Association> {

    @Autowired
    private AssociationCrudService associationService;

    @Override
    public CrudService<Association> service() {
        return this.associationService;
    }
}
