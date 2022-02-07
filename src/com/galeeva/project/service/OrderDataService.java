package com.galeeva.project.service;

import com.galeeva.project.dao.OrderDataDao;
import com.galeeva.project.dto.OrderDataDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDataService {

    private static final OrderDataService INSTANCE = new OrderDataService();

    private final OrderDataDao orderDataDao = OrderDataDao.getInstance();

    private OrderDataService() {
    }

    public List<OrderDataDto> findAllByServiceid(Long serviceId) {
        return orderDataDao.findAllByServiceId(serviceId).stream()
                .map(orderData -> new OrderDataDto(
                        orderData.getId(),
                        orderData.getServiceId(),
                        orderData.getFile(),
                        orderData.getStatus(),
                        orderData.getDelivery()
                ))
                .collect(Collectors.toList());
    }

    public static OrderDataService getInstance() {
        return INSTANCE;
    }
}
