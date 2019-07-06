package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.UserCrudService;
import com.donation.donor.model.User;
import com.donation.web.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
