package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.UserCrudService;
import com.donation.donor.UserCrudRepository;
import com.donation.donor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCrudServiceImpl extends CrudServiceImpl<User> implements UserCrudService {

    @Autowired
    private UserCrudRepository userRepository;

    @Autowired
    private PasswordEncoder encoder=new BCryptPasswordEncoder();

    @Override
    public User add (User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if(!userExists(user.getEmail())) {
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User update(User objectToUpdate, User newObjectData){
        if(newObjectData.getEmail()!=null && !userExists(newObjectData.getEmail())){
            objectToUpdate.setEmail(newObjectData.getEmail());
        }

        if(newObjectData.getPassword()!=null){
            objectToUpdate.setPassword(newObjectData.getPassword());
        }
        userRepository.save(objectToUpdate);
        return objectToUpdate;
    }

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
    public User findByUsername(String username) {
        List<User> users = userRepository.findAll();
        for (User user : users) {

            if (user.getEmail().equals(username))
                return user;
        }
        return null;
    }

    @Override
    protected CrudRepository<User, Long> repository() {
        return userRepository;
    }
}
