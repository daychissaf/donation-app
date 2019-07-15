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

    @Override
    @Secured("ROLE_ADMIN")
    @PostMapping
    public Association add(@Valid @RequestBody Association object) {
        return service().add(object);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody Association newObjectData) {
        Association objectToUpdate = service().getById(id);
        if (objectToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service().update(objectToUpdate, newObjectData), HttpStatus.OK);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping
    @ResponseBody
    public List<Association> list() {
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
    public Association getById(@PathVariable Long id) {
        return service().getById(id);
    }
}
