package com.kodnest.beatbox.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.beatbox.entity.Playlist;


@Repository
public interface PlaylistRepository extends  JpaRepository<Playlist , Integer>{

	Playlist findByName(String name);


}
