package com.kodnest.beatbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.beatbox.entity.Playlist;
import com.kodnest.beatbox.repository.PlaylistRepository;
import com.kodnest.beatbox.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired 
	PlaylistRepository  playlistRepository;

	@Override
	public void addPlaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}

	@Override
	public boolean playlistExists(String name) {
	 Playlist playlist = playlistRepository.findByName(name);

		if (playlist != null) {
			System.out.println("Present");
			return true ;

		} else  {
			System.out.println("Absent");
			return false;
		
	    }	
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
	     List<Playlist> playlists = playlistRepository.findAll() ;
	     return playlists;
	}

	}
