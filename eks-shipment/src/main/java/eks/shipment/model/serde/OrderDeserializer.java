package eks.shipment.model.serde;

import eks.shipment.model.Order;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class OrderDeserializer extends JsonDeserializer<Order> {
    public OrderDeserializer() {
        super(Order.class);
    }
}
