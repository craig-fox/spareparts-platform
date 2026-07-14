package nz.fox.craig.order.dto;

public record CustomerResponse(
    Long id,
    String name,
    String email,
    String address
) {
}
