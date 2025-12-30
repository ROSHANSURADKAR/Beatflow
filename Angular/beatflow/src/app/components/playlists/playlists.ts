import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api-service';
import { Playlist } from '../../models/playlist';

@Component({
  selector: 'app-playlists',
  imports: [CommonModule, FormsModule],
  templateUrl: './playlists.html',
  styleUrl: './playlists.css',
})
export class Playlists {
  @Input() userId!: number;
  @Input() playlists: Playlist[] = [];
  @Output() refresh = new EventEmitter();
  newName = '';

  constructor(private api: ApiService) {}

  create() {
    this.api.createPlaylist({ name: this.newName, userId: this.userId, songIds: [] })
      .subscribe(() => { this.newName = ''; this.refresh.emit(); });
  }


}
