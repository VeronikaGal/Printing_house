package com.galeeva.project.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ServiceDto {

    Integer id;
    String description;
}
