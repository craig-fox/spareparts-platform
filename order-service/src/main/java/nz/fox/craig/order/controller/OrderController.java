package nz.fox.craig.order.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nz.fox.craig.order.dto.OrderRequest;
import nz.fox.craig.order.dto.OrderResponse;
import nz.fox.craig.order.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
		OrderResponse response = orderService.createOrder(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{id}")
	public OrderResponse getOrder(@PathVariable Long id) {
		return orderService.getOrder(id);
	}

	@PutMapping("/{id}")
	public OrderResponse updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequest request) {
		return orderService.updateOrder(id, request);
	}

	@PostMapping("/{id}/cancel")
	public OrderResponse cancelOrder(@PathVariable Long id) {
		return orderService.cancelOrder(id);
	}

}
