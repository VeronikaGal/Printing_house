package com.galeeva.project.dto;

import com.galeeva.project.entity.MachineModel;
import com.galeeva.project.entity.MachineType;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class MachineDto {

    Integer id;
    MachineModel model;
    MachineType type;
}
