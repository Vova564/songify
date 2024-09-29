package org.example.songify.domain.crud.dto;

import lombok.Builder;

@Builder
public record SongDTO(Long id, String name) {

}
