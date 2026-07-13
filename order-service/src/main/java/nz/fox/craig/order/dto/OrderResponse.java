package nz.fox.craig.order.dto;

import java.time.LocalDateTime;

import nz.fox.craig.order.Order;
import nz.fox.craig.order.OrderStatus;


public record OrderResponse(
		Long id,
		Long customerId,
		Long productId,
		Integer quantity,
		LocalDateTime orderDateTime,
		OrderStatus status
) {

	public static OrderResponse from(Order order) {
		return new OrderResponse(
				order.getId(),
				order.getCustomerId(),
				order.getProductId(),
				order.getQuantity(),
				order.getOrderDateTime(),
				order.getStatus()
		);
	}

}
