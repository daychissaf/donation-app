package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.UserCrudService;
import com.donation.donor.model.User;
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
@RequestMapping(value = "/api/users")
public class UserCrudController extends CrudController<User> {

    @Autowired
    private UserCrudService userService;

    @Override
    public CrudService<User> service() {
        return this.userService;
    }

    @Override
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody User newObjectData) {
        User objectToUpdate = service().getById(id);
        if (objectToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service().update(objectToUpdate, newObjectData), HttpStatus.OK);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping
    @ResponseBody
    public List<User> list() {
        return service().getAll();
    }

    @Override
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service().delete(id);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service().getById(id);
    }
}
