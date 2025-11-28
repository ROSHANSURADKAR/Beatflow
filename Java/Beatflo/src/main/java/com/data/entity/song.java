package com.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long songid;

    String title;
    String artist;
    String album;
    String genre;

    String fileUrl;   // URL of uploaded song
    String coverUrl;  // Album image

    public song() {}

    public song(Long id, String title, String artist, String album, String genre, String fileUrl, String coverUrl) {
        this.songid = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.fileUrl = fileUrl;
        this.coverUrl = coverUrl;
    }

    // Getters & Setters
    public Long getId() { return songid; }
    public void setId(Long id) { this.songid = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public String getCoverUrl() { return coverUrl; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }
}