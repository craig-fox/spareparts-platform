package nz.fox.craig.order.exception;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(Long id) {
		super(String.format( "Order %s not found", id));
	}

}
