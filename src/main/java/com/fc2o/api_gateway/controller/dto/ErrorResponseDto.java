package com.fc2o.api_gateway.controller.dto;

import lombok.Builder;

@Builder
public record ErrorResponseDto(
  String dateTime,
  String message
) {
}
