package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.song;

public interface SongRepository extends JpaRepository<song, Long> {
	 List<song> findByTitleContainingIgnoreCase(String keyword);
	    List<song> findByArtistContainingIgnoreCase(String artist);
	    List<song> findByGenre(String genre);

}
