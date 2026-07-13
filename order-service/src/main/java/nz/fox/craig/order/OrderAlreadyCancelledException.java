package nz.fox.craig.order;

public class OrderAlreadyCancelledException extends RuntimeException {

	public OrderAlreadyCancelledException(Long id) {
		super("Order is already cancelled with id: " + id);
	}

}
