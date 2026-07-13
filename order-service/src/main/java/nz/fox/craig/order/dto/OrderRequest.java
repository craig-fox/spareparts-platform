package nz.fox.craig.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
		@NotNull(message = "Customer id is required")
		Long customerId,
		@NotNull(message = "Product id is required")
		Long productId,
		@NotNull(message = "Quantity is required")
		@Min(value = 1, message = "Quantity must be at least 1")
		Integer quantity
) {
}
