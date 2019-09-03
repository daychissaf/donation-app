package com.donation.web;

import com.donation.crud.AssociationCrudService;
import com.donation.donor.model.Association;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/association")
@RestController

public class AssociationController {

    @Autowired
    private AssociationCrudService associationCrudService;

    @GetMapping
    public List<Association> getSponsors() {
        return associationCrudService.getAll();
    }
}
