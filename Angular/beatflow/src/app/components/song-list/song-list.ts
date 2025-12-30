import { Component,Input,Output } from '@angular/core';
import { Song } from '../../models/song';
import { EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-song-list',
  imports: [CommonModule,FormsModule],
  templateUrl: './song-list.html',
  styleUrl: './song-list.css',
})
export class SongList {
@Input() songs: Song[] = [];
  @Output() play = new EventEmitter<Song>();
  @Output() add = new EventEmitter<number>();
  @Output() like = new EventEmitter<number>();
}
