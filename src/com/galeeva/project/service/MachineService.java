package com.galeeva.project.service;

import com.galeeva.project.dao.MachineDao;
import com.galeeva.project.dto.MachineDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MachineService {
    private static final MachineService INSTANCE = new MachineService();

    private final MachineDao machineDao = MachineDao.getInstance();

    private MachineService() {
    }

    public List<MachineDto> findAllByServiceId(Integer orderDataId) {
        return machineDao.findById(orderDataId).stream()
                .map(machine -> new MachineDto(
                        machine.getId(),
                        machine.getModel(),
                        machine.getType()
                ))
                .collect(toList());
    }

    public static MachineService getInstance() {
        return INSTANCE;
    }
}
