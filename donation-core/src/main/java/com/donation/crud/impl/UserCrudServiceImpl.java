package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.UserCrudService;
import com.donation.donor.UserCrudRepository;
import com.donation.donor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCrudServiceImpl extends CrudServiceImpl<User> implements UserCrudService {

    @Autowired
    private UserCrudRepository userRepository;

    @Override
    public boolean userExists(String email) {

        List<User> users;
        users = userRepository.findAll();

        if (users == null)
            return false;

        for (User user : users) {

            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    protected CrudRepository<User, Long> repository() {
        return userRepository;
    }
}
