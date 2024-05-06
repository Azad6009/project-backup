package com.kodnest.beatbox.service;



import java.util.List;

import com.kodnest.beatbox.entity.Playlist;

public interface PlaylistService {



	void addPlaylist(Playlist playlist);

	boolean playlistExists(String name);

	List<Playlist> fetchAllPlaylists();




}
