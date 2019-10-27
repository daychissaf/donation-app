package com.donation.web;

import com.donation.crud.*;
import com.donation.donor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/populateDatabase")
public class DataController {
    @Autowired
    UserCrudService userCrudService;
    @Autowired
    AssociationCrudService associationCrudService;
    @Autowired
    SponsorCrudService sponsorCrudService;
    @Autowired
    VideoCrudService videoCrudService;
    @Autowired
    ProjectCrudService projectCrudService;

    List<Video> list1 = new ArrayList<>();
    List<Video> list2 = new ArrayList<>();
    List<Video> list3 = new ArrayList<>();
    List<Video> list4 = new ArrayList<>();
    List<Video> list5 = new ArrayList<>();
    String imagePath = "/assets/image/project-image.png";

    @GetMapping
    public String populateDatabase() {
        //add User and Admin                    ****************************************
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("user");
        userCrudService.add(user);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.setRole("ADMIN");
        userCrudService.add(admin);

        //add 5 sponsors with their videos      ****************************************
        //**************Sponsor
        Sponsor sponsor = new Sponsor();
        sponsor.setName("Maroc Telecom");
        sponsor.setImgPath(imagePath);
        sponsorCrudService.add(sponsor);
        //********
        Video video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("IAM_1");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list1.add(video);
        list2.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("IAM_2");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list1.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("IAM_3");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list1.add(video);

        //**************Sponsor
        sponsor = new Sponsor();
        sponsor.setName("Orange");
        sponsor.setImgPath(imagePath);
        sponsorCrudService.add(sponsor);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Orange_1");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list2.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Orange_2");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list5.add(video);

        //**************Sponsor
        sponsor = new Sponsor();
        sponsor.setName("Banque Populaire");
        sponsor.setImgPath(imagePath);
        sponsorCrudService.add(sponsor);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("BP_1");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list2.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("BP_2");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list5.add(video);

        //**************Sponsor
        sponsor = new Sponsor();
        sponsor.setName("Lenovo");
        sponsor.setImgPath(imagePath);
        sponsorCrudService.add(sponsor);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Lenovo_1");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list2.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Lenovo_2");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list4.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Lenovo_3");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list5.add(video);

        //**************Sponsor
        sponsor = new Sponsor();
        sponsor.setName("Indomie");
        sponsor.setImgPath(imagePath);
        sponsorCrudService.add(sponsor);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Indomie_1");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list2.add(video);
        list3.add(video);
        //********
        video = new Video();
        video.setSponsor(sponsor);
        video.setTitle("Indomie_2");
        video.setLink("/assets/video/video.mp4");
        videoCrudService.add(video);
        list3.add(video);

        //add 5 associations    ****************************************
        Association association = new Association();
        association.setName("Association Al Amal");
        association.setImgPath(imagePath);
        associationCrudService.add(association);
        association = new Association();
        association.setName("Association of Fight Against AIDS");
        association.setImgPath(imagePath);
        associationCrudService.add(association);
        association = new Association();
        association.setName("Association Salon du Cheval");
        association.setImgPath(imagePath);
        associationCrudService.add(association);
        association = new Association();
        association.setName("Association Al Baraka");
        association.setImgPath(imagePath);
        associationCrudService.add(association);
        association = new Association();
        association.setName("Association Ribat Al Fath");
        association.setImgPath(imagePath);
        associationCrudService.add(association);

        //add 5 Projects    ****************************************
        Project project = new Project();
        project.setTitle("Project_1");
        project.setDescription("Project_1_desc");
        project.setImgPath(imagePath);
        project.setAssociation(associationCrudService.getById(Long.valueOf(1)));
        project.setVideos(list1);
        projectCrudService.add(project);
        //**********
        project = new Project();
        project.setTitle("Project_2");
        project.setDescription("Project_2_desc");
        project.setImgPath(imagePath);
        project.setAssociation(associationCrudService.getById(Long.valueOf(2)));
        project.setVideos(list2);
        projectCrudService.add(project);
        //**********
        project = new Project();
        project.setTitle("Project_3");
        project.setDescription("Project_3_desc");
        project.setImgPath(imagePath);
        project.setAssociation(associationCrudService.getById(Long.valueOf(3)));
        project.setVideos(list3);
        projectCrudService.add(project);
        //**********
        project = new Project();
        project.setTitle("Project_4");
        project.setDescription("Project_4_desc");
        project.setImgPath(imagePath);
        project.setAssociation(associationCrudService.getById(Long.valueOf(4)));
        project.setVideos(list4);
        projectCrudService.add(project);
        //**********
        project = new Project();
        project.setTitle("Project_5");
        project.setDescription("Project_5_desc");
        project.setImgPath(imagePath);
        project.setAssociation(associationCrudService.getById(Long.valueOf(5)));
        project.setVideos(list5);
        projectCrudService.add(project);

        return "filling database...\nDone.";
    }
}
