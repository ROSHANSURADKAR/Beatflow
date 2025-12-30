package com.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.song;
import com.data.service.SongService;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "http://localhost:4200")
public class SongController {

    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public song addSong(@RequestBody song song) {
        return service.addSong(song);
    }

    @GetMapping("/all")
    public List<song> getAllSongs() {
        return service.getAllSongs();
    }

    @GetMapping("/{id}")
    public song getSong(@PathVariable Long id) {
        return service.getSongById(id);
    }
}
