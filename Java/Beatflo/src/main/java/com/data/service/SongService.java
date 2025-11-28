package com.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.data.entity.song;
import com.data.repository.SongRepository;

@Service
public class SongService {

    private final SongRepository repo;

    public SongService(SongRepository repo) {
        this.repo = repo;
    }

    public song addSong(song song) {
        return repo.save(song);
    }

    public List<song> getAllSongs() {
        return repo.findAll();
    }

    public song getSongById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
