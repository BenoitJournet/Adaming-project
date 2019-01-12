package com.inti.services;

import java.util.List;

import com.inti.entities.Photo;

public interface PhotoService {

	public List<Photo> findAllPhoto();
	public Photo findOnePhotobyId(long photo_id);
	public void suppPhoto(long photo_id);
	public Photo save(Photo photo);
	public Photo editPhoto(Photo photo);
}
