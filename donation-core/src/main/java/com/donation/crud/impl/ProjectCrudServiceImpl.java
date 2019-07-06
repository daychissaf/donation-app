package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.ProjectCrudService;
import com.donation.donor.ProjectCrudRepository;
import com.donation.donor.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectCrudServiceImpl extends CrudServiceImpl<Project> implements ProjectCrudService {

   @Autowired
   private ProjectCrudRepository projectCrudRepository;

   @Override
   protected CrudRepository<Project, Long> repository() {
      return projectCrudRepository;
   }
}
