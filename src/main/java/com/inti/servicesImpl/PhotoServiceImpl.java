package com.inti.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Photo;
import com.inti.repository.PhotoRepository;
import com.inti.services.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoRepository photoRepo;

	@Override
	public List<Photo> findAllPhoto() {
		
		return photoRepo.findAll();
	}

	@Override
	public Photo findOnePhotobyId(long photo_id) {
		
		return photoRepo.findbyId(photo_id);
	}

	@Override
	public void suppPhoto(long photo_id) {
		photoRepo.deleteById(photo_id);
		
	}

	@Override
	public Photo save(Photo photo) {
		
		return photoRepo.save(photo);
	}

	@Override
	public Photo editPhoto(Photo photo) {
		
		return photoRepo.save(photo);
	}
}
