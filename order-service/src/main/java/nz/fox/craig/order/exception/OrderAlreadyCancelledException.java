package nz.fox.craig.order.exception;

public class OrderAlreadyCancelledException extends RuntimeException {

	public OrderAlreadyCancelledException(Long id) {
		super(String.format( "Order %s is already cancelled", id));
	}

}
