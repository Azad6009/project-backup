package com.kodnest.beatbox.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.beatbox.entity.Song;
import com.kodnest.beatbox.service.SongService;



@Controller
public class SongController {

	@Autowired
	SongService songService;
	

	
	@PostMapping("/addsongs")
	public String addSong(@ModelAttribute  Song song ) {

        String name = song.getName();
         
		boolean songExists = songService.songExists(name);

		if(songExists == false) {

			songService.saveSong(song);
			System.out.println("song Added Successfully");

		}
		else {

			System.out.println("Duplicate song");	
		}
		return "adminhome";

	}
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {

		List<Song> songs = songService.fetchAllSongs();
		model.addAttribute("songs" , songs);
		System.out.println(songs);
		return "viewsongs";
	}

	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
		List<Song> songs = songService.fetchAllSongs();
		model.addAttribute("songs" , songs);
		System.out.println(songs);
		return "playsongs";/*
		 * boolean premium = false; if(premium) { List<Song> songs =
		 * songService.fetchAllSongs(); model.addAttribute("songs" , songs);
		 * System.out.println(songs); return "playsongs"; } else { return "playsongs"; }
		 */
	}
	
	
	
}
