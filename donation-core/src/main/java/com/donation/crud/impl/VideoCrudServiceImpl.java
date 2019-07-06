package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.VideoCrudService;
import com.donation.donor.VideoCrudRepository;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoCrudServiceImpl extends CrudServiceImpl<Video> implements VideoCrudService {

   @Autowired
   private VideoCrudRepository videoCrudRepository;

   @Override protected CrudRepository<Video, Long> repository() {
      return videoCrudRepository;
   }
}
