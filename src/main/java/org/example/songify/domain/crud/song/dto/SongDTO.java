package org.example.songify.domain.crud.song.dto;

import lombok.Builder;

@Builder
public record SongDTO(Long id, String song) {

}
