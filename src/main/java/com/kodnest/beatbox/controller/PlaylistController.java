package com.kodnest.beatbox.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.beatbox.entity.Playlist;
import com.kodnest.beatbox.entity.Song;
import com.kodnest.beatbox.service.PlaylistService;
import com.kodnest.beatbox.service.SongService;

@Controller
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylists")
	public String createPlaylist(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs" , songList);
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
        String name =playlist .getName();
		boolean  playlistExists= playlistService.playlistExists(name);

		if(playlistExists == false) {
			playlistService.addPlaylist(playlist);

		}
		else {
			System.out.println("Duplicate Playlist");	
		}
		List<Song> songs = playlist.getSongs();
		for (Song song: songs) {
              song.getPlaylists().add(playlist)	;	
              songService.updateSong(song);
		}
		return "adminhome";
      }
	
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model){
	    List<Playlist> playlists = playlistService.fetchAllPlaylists(); 
	    model.addAttribute("playlists", playlists);
	    return "viewplaylist"; 
	}
	
	
}

