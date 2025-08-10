package com.wipro.orderms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private double paymentId;
    private int orderId;
    private boolean paymentStatus;
}
