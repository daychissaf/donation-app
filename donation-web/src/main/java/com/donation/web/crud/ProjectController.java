package com.donation.web.crud;

import com.donation.crud.ProjectCrudService;
import com.donation.crud.UserCrudService;
import com.donation.donor.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/api/projects")
@RestController
public class ProjectController {

    @Autowired
    UserCrudService userCrudService;

    @Autowired
    ProjectCrudService projectCrudService;

    //Everybody can view all projects
    @GetMapping
    public List<Project> getProjects() {
        return projectCrudService.getAll();
    }

    //Everybody can view a specific project
    @GetMapping("/{id}")
    public Project getProject(@PathVariable("id") Long id) {
        return projectCrudService.getById(id);
    }
}
