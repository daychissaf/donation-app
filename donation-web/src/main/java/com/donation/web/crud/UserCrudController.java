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
}
