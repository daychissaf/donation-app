package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.AssociationCrudService;
import com.donation.donor.model.Association;
import com.donation.donor.model.Project;
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
@RequestMapping(value = "/api/associations")
public class AssociationCrudController extends CrudController<Association> {

    @Autowired
    private AssociationCrudService associationService;

    @Override
    public CrudService<Association> service() {
        return this.associationService;
    }

}
