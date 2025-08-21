package org.vkhoma.orderservice.order.event;

public record OrderDispatchedMessage(
        Long orderId
) {}
