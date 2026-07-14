package nz.fox.craig.order.exception;

/**
 * CustomerNotFoundException
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
		super("Customer not found with id: " + id);
	}

}
