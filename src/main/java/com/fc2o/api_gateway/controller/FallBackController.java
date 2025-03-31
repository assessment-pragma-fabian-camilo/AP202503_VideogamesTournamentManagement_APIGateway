package com.fc2o.api_gateway.controller;

import com.fc2o.api_gateway.controller.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class FallBackController {

  @GetMapping("/fallback/orchestrator")
  public ResponseEntity<ErrorResponseDto> orchestratorGetFallback() {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
      .body(
        ErrorResponseDto.builder()
          .dateTime(LocalDateTime.now().toString())
          .message("Servicio Orquestador no disponible. Inténtelo más tarde.")
          .build()
      );
  }
  @PostMapping("/fallback/orchestrator")
  public ResponseEntity<ErrorResponseDto> orchestratorPostFallback() {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
      .body(
        ErrorResponseDto.builder()
          .dateTime(LocalDateTime.now().toString())
          .message("Servicio Orquestador no disponible. Inténtelo más tarde.")
          .build()
      );
  }
  @PatchMapping("/fallback/orchestrator")
  public ResponseEntity<ErrorResponseDto> orchestratorPatchFallback() {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
      .body(
        ErrorResponseDto.builder()
          .dateTime(LocalDateTime.now().toString())
          .message("Servicio Orquestador no disponible. Inténtelo más tarde.")
          .build()
      );
  }
  @DeleteMapping("/fallback/orchestrator")
  public ResponseEntity<ErrorResponseDto> orchestratorDeleteFallback() {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
      .body(
        ErrorResponseDto.builder()
          .dateTime(LocalDateTime.now().toString())
          .message("Servicio Orquestador no disponible. Inténtelo más tarde.")
          .build()
      );
  }

  @GetMapping("/fallback/airtable")
  public ResponseEntity<ErrorResponseDto> airtableFallback() {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
      .body(
        ErrorResponseDto.builder()
          .dateTime(LocalDateTime.now().toString())
          .message("Servicio Airtable no disponible. Inténtelo más tarde.")
          .build()
      );
  }
}