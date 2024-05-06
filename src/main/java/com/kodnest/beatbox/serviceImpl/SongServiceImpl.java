package com.kodnest.beatbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kodnest.beatbox.entity.Song;
import com.kodnest.beatbox.repository.SongRepository;
import com.kodnest.beatbox.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	
	@Autowired 
	SongRepository  songRepository;

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
	}


	@Override
	public boolean songExists(String name ) {
		Song song = songRepository.findByName(name);

		if (song != null) {
			System.out.println("Present");
			return true ;

		} else  {
			System.out.println("Absent");
			return false;
		
	    }	
	
	}


	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songRepository.findAll();
		return songs;
	}


	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
	}



}

	




