package com.galeeva.project.dto;

import com.galeeva.project.entity.OrderDelivery;
import com.galeeva.project.entity.OrderStatus;
import com.galeeva.project.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@AllArgsConstructor
@Data
public class OrderDataDto {

    private final Long id;
    private final ServiceEntity serviceId;
    private final String file;
    private final OrderStatus status;
    private final OrderDelivery delivery;
}
