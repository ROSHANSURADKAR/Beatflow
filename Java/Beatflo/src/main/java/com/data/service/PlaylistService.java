package com.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.data.entity.Playlist;
import com.data.repository.PlaylistRepository;

@Service
public class PlaylistService {
    private final PlaylistRepository repo;
    public PlaylistService(PlaylistRepository repo){ this.repo = repo; }

    public Playlist create(Playlist p){ p.setId(null); return repo.save(p); }
    public Playlist addSong(Long playlistId, Long songId){
        Playlist p = repo.findById(playlistId).orElseThrow();
        p.getSongIds().add(songId);
        return repo.save(p);
    }
    public List<Playlist> byUser(Long userId){ return repo.findByUserId(userId); }

}
