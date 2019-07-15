package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.VideoCrudService;
import com.donation.donor.model.Sponsor;
import com.donation.donor.model.Video;
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
@RequestMapping(value = "/api/videos")
public class VideoCrudController extends CrudController<Video> {

    @Autowired
    private VideoCrudService videoService;

    @Override
    public CrudService<Video> service() {
        return this.videoService;
    }

    @Override
    @Secured("ROLE_ADMIN")
    @PostMapping
    public Video add(@Valid @RequestBody Video object) {
        return service().add(object);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody Video newObjectData) {
        Video objectToUpdate = service().getById(id);
        if (objectToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service().update(objectToUpdate, newObjectData), HttpStatus.OK);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping
    @ResponseBody
    public List<Video> list() {
        return service().getAll();
    }

    @Override
    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service().delete(id);
    }

    @Override
    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public Video getById(@PathVariable Long id) {
        return service().getById(id);
    }
}

