package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.ProjectCrudService;
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
@RequestMapping(value = "/api/projects")
public class ProjectCrudController extends CrudController<Project> {

    @Autowired
    private ProjectCrudService projectService;

    @Override
    public CrudService<Project> service() {
        return this.projectService;
    }

}
