package com.donation.web.crud;

import com.donation.crud.UserCrudService;
import com.donation.donor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account")
public class RegistrationController {

    @Autowired
    UserCrudService userCrudService;

    @PostMapping
    public User register(@RequestBody User user) {
        return userCrudService.add(user);
    }

    //Must be logged in to update your account
    @Secured("ROLE_USER")
    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userCrudService.update(userCrudService.getById(id),user);
    }

    //Must be logged in to delete your account
    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userCrudService.delete(id);
    }

}
