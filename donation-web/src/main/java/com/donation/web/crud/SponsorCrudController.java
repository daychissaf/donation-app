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

    @Override
    @Secured("ROLE_ADMIN")
    @PostMapping
    public Sponsor add(@Valid @RequestBody Sponsor object) {
        return service().add(object);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody Sponsor newObjectData) {
        Sponsor objectToUpdate = service().getById(id);
        if (objectToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service().update(objectToUpdate, newObjectData), HttpStatus.OK);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping
    @ResponseBody
    public List<Sponsor> list() {
        return service().getAll();
    }

    @Override
    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service().delete(id);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public Sponsor getById(@PathVariable Long id) {
        return service().getById(id);
    }
}
