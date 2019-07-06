package com.donation.crud;

import com.donation.common.CrudService;
import com.donation.donor.model.User;

public interface UserCrudService extends CrudService<User> {

    boolean userExists(String email);
}
