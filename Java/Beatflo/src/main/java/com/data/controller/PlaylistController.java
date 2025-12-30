package com.data.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Playlist;
import com.data.service.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaylistController {
    private final PlaylistService service;
    public PlaylistController(PlaylistService service){ this.service = service; }

    @PostMapping("/create")
    public Playlist create(@RequestBody Playlist p){ return service.create(p); }

    @PostMapping("/{id}/add/{songId}")
    public Playlist addSong(@PathVariable Long id, @PathVariable Long songId)
    { 
    	return service.addSong(id, songId); 
    	}

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> byUser(@PathVariable Long userId) {
        if (userId == null) {
            return ResponseEntity.badRequest().body("User ID cannot be null");
        }
        return ResponseEntity.ok(service.byUser(userId));
    }
}
