package com.donation.web.crud;

import com.donation.crud.ProjectCrudService;
import com.donation.crud.UserCrudService;
import com.donation.donor.model.Project;
import com.donation.donor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PublicController {

    @Autowired
    UserCrudService userCrudService;

    @Autowired
    ProjectCrudService projectCrudService;

    //Everybody can create an account
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userCrudService.add(user);
    }

    //Must be logged in to update your account
    @Secured("ROLE_USER")
    @PutMapping("/account/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userCrudService.update(userCrudService.getById(id),user);
    }

    //Must be logged in to delete your account
    @Secured("ROLE_USER")
    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable("id") Long id) {
         userCrudService.delete(id);
    }

    //Everybody can view all projects
    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectCrudService.getAll();
    }

    //Everybody can view a specific project
    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable("id") Long id) {
        return projectCrudService.getById(id);
    }
}
