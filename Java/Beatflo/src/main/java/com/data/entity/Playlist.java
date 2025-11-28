package com.data.entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long playid;
   Long userId;
   String name;

    // store song ids for simplicity (or create PlaylistSong join table for relational)
    @ElementCollection
    //@CollectionTable(name = "playlist_songs", joinColumns = @JoinColumn(name = "playlist_id"))
    @Column(name = "songid")
    private List<Long> songIds;

    public Playlist(){}
    // getters / setters ...
 
    public Long getId(){return playid;}
    public void setId(Long id){this.playid = id;}
    public Long getUserId(){return userId;}
    public void setUserId(Long userId){this.userId = userId;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public List<Long> getSongIds(){return songIds;}
    public void setSongIds(List<Long> songIds){this.songIds = songIds;}
}
