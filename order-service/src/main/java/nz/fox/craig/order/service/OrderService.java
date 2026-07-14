package nz.fox.craig.order.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import nz.fox.craig.order.client.CustomerClient;
import nz.fox.craig.order.dto.OrderRequest;
import nz.fox.craig.order.dto.OrderResponse;
import nz.fox.craig.order.exception.OrderAlreadyCancelledException;
import nz.fox.craig.order.exception.OrderNotFoundException;
import nz.fox.craig.order.model.Order;
import nz.fox.craig.order.model.OrderStatus;
import nz.fox.craig.order.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final CustomerClient customerClient;
	

	@Transactional
	public OrderResponse createOrder(OrderRequest request) {

		customerClient.validateCustomerExists(request.customerId());
	
		Order order = Order.builder()
				.customerId(request.customerId())
				.productId(request.productId())
				.quantity(request.quantity())
				.orderDateTime(LocalDateTime.now())
				.status(OrderStatus.PLACED)
				.build();
		return OrderResponse.from(orderRepository.save(order));
	}

	@Transactional(readOnly = true)
	public OrderResponse getOrder(Long id) {
		return orderRepository.findById(id)
				.map(OrderResponse::from)
				.orElseThrow(() -> new OrderNotFoundException(id));
	}

	@Transactional
	public OrderResponse updateOrder(Long id, OrderRequest request) {
		
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
		if (order.getStatus() == OrderStatus.CANCELLED) {
			throw new OrderAlreadyCancelledException(id);
		}
		customerClient.validateCustomerExists(request.customerId());
		
		order.setCustomerId(request.customerId());
		order.setProductId(request.productId());
		order.setQuantity(request.quantity());
		return OrderResponse.from(orderRepository.save(order));
	}

	@Transactional
	public OrderResponse cancelOrder(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
		if (order.getStatus() == OrderStatus.CANCELLED) {
			throw new OrderAlreadyCancelledException(id);
		}
		order.setStatus(OrderStatus.CANCELLED);
		return OrderResponse.from(orderRepository.save(order));
	}



}
