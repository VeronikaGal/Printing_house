package com.galeeva.project.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserDto {

    Long id;
    String description;
}
