package org.example.songify.infrastructure.apivalidation;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ApiValidationResponseDTO(List<String> errors, HttpStatus httpStatus) {
}
