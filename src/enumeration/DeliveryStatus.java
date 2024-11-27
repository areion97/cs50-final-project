package enumeration;

public enum DeliveryStatus {
    NOT_PREPARED("NOT_PREPARED"),
    IN_PREPARATION("IN_PREPARATION"),
    DELIVERED("DELIVERED"),
    IN_DELIVERY("IN_DELIVERY");

    public final String label;

    DeliveryStatus(String deliveryStatus) {
        label = deliveryStatus;
    }
}
