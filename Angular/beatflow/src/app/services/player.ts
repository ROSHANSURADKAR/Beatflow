import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Song } from '../models/song';


@Injectable({ providedIn: 'root' })
export class PlayerService {
  private audio = new Audio();

  currentSong$ = new BehaviorSubject<Song | null>(null);
  isPlaying$ = new BehaviorSubject<boolean>(false);

  constructor() {
    this.audio.onended = () => this.isPlaying$.next(false);
  }

  playSong(song: Song) {
    if (this.currentSong$.value?.songid !== song.songid) {
      this.audio.src = song.fileUrl;

  this.audio.load();
  this.audio.play();
      this.currentSong$.next(song);
    }
    this.audio.play();
    this.isPlaying$.next(true);
  }

  pauseSong() {
    this.audio.pause();
    this.isPlaying$.next(false);
  }

  togglePlay() {
    if (this.isPlaying$.value) this.pauseSong();
    else if (this.currentSong$.value) this.audio.play();
  }

}
