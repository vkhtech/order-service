package org.vkhoma.orderservice.order.event;

public record OrderAcceptedMessage(
        Long orderId
) {}
