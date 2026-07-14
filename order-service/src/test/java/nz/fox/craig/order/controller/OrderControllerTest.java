package nz.fox.craig.order.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import nz.fox.craig.order.dto.OrderRequest;
import nz.fox.craig.order.dto.OrderResponse;
import nz.fox.craig.order.exception.CustomerNotFoundException;
import nz.fox.craig.order.exception.OrderAlreadyCancelledException;
import nz.fox.craig.order.exception.OrderExceptionHandler;
import nz.fox.craig.order.exception.OrderNotFoundException;
import nz.fox.craig.order.model.OrderStatus;
import nz.fox.craig.order.service.OrderService;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(OrderController.class)
@Import(OrderExceptionHandler.class)
class OrderControllerTest {
    @Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

    @MockitoBean
    private OrderService orderService;

    private OrderResponse sampleResponse() {
		return new OrderResponse(
				1L,
				10L,
				20L,
				3,
				LocalDateTime.of(2026, 7, 14, 10, 0),
				OrderStatus.PLACED
		);
	}

    @Test
	void createOrder_returnsCreatedOrder() throws Exception {
		OrderRequest request = new OrderRequest(10L, 20L, 3);
		OrderResponse response = sampleResponse();

		when(orderService.createOrder(any(OrderRequest.class))).thenReturn(response);

		mockMvc.perform(post("/api/orders")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.customerId").value(10L))
				.andExpect(jsonPath("$.productId").value(20L))
				.andExpect(jsonPath("$.quantity").value(3))
				.andExpect(jsonPath("$.status").value("PLACED"));
	}

    @Test
	void createOrder_missingCustomerId_returnsBadRequest() throws Exception {
		OrderRequest request = new OrderRequest(null, 20L, 3);

		mockMvc.perform(post("/api/orders")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("customerId: Customer id is required"));
	}

    @Test
    void createOrder_customerNotFound_returns404() throws Exception {
        OrderRequest request = new OrderRequest(99L, 20L, 3);

        when(orderService.createOrder(any(OrderRequest.class)))
                .thenThrow(new CustomerNotFoundException(99L));

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Customer not found with id: 99"));
    }

    @Test
	void createOrder_quantityBelowMinimum_returnsBadRequest() throws Exception {
		OrderRequest request = new OrderRequest(10L, 20L, 0);

		mockMvc.perform(post("/api/orders")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("quantity: Quantity must be at least 1"));
	}

    // ---- getOrder ----

	@Test
	void getOrder_returnsOrder() throws Exception {
		when(orderService.getOrder(1L)).thenReturn(sampleResponse());

		mockMvc.perform(get("/api/orders/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.status").value("PLACED"));
	}

	@Test
	void getOrder_notFound_returns404() throws Exception {
		when(orderService.getOrder(99L)).thenThrow(new OrderNotFoundException(99L));

		mockMvc.perform(get("/api/orders/{id}", 99L))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("Order 99 not found"));
	}

    // ---- updateOrder ----

	@Test
	void updateOrder_returnsUpdatedOrder() throws Exception {
		OrderRequest request = new OrderRequest(10L, 20L, 5);
		OrderResponse updated = new OrderResponse(1L, 10L, 20L, 5, LocalDateTime.now(), OrderStatus.PENDING);

		when(orderService.updateOrder(eq(1L), any(OrderRequest.class))).thenReturn(updated);

		mockMvc.perform(put("/api/orders/{id}", 1L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.quantity").value(5));
	}

	@Test
	void updateOrder_notFound_returns404() throws Exception {
		OrderRequest request = new OrderRequest(10L, 20L, 5);

		when(orderService.updateOrder(eq(99L), any(OrderRequest.class)))
				.thenThrow(new OrderNotFoundException(99L));

		mockMvc.perform(put("/api/orders/{id}", 99L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("Order 99 not found"));
	}

    @Test
	void updateOrder_invalidRequest_returnsBadRequest() throws Exception {
		OrderRequest request = new OrderRequest(10L, null, 5);

		mockMvc.perform(put("/api/orders/{id}", 1L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("productId: Product id is required"));
	}

    // ---- cancelOrder ----

	@Test
	void cancelOrder_returnsCancelledOrder() throws Exception {
		OrderResponse cancelled = new OrderResponse(1L, 10L, 20L, 3, LocalDateTime.now(), OrderStatus.CANCELLED);

		when(orderService.cancelOrder(1L)).thenReturn(cancelled);

		mockMvc.perform(post("/api/orders/{id}/cancel", 1L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("CANCELLED"));
	}

	@Test
	void cancelOrder_notFound_returns404() throws Exception {
		when(orderService.cancelOrder(99L)).thenThrow(new OrderNotFoundException(99L));

		mockMvc.perform(post("/api/orders/{id}/cancel", 99L))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.message").value("Order 99 not found"));
	}

	@Test
	void cancelOrder_alreadyCancelled_returnsConflict() throws Exception {
		when(orderService.cancelOrder(1L))
				.thenThrow(new OrderAlreadyCancelledException(1L));

		mockMvc.perform(post("/api/orders/{id}/cancel", 1L))
				.andExpect(status().isConflict())
				.andExpect(jsonPath("$.message").value("Order 1 is already cancelled"));
	}


}
