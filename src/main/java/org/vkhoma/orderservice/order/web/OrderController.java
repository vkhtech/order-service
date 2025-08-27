package org.vkhoma.orderservice.order.web;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.vkhoma.orderservice.order.domain.Order;
import org.vkhoma.orderservice.order.domain.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders(
            @AuthenticationPrincipal Jwt jwt
    ) {
        return orderService.getAllOrders(jwt.getSubject());
    }

    @PostMapping
    public Mono<Order> submitOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.submitOrder(orderRequest.isbn(), orderRequest.quantity());
    }

}
