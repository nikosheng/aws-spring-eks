package eks.user.model.serde;

import eks.user.model.Order;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class OrderDeserializer extends JsonDeserializer<Order> {
    public OrderDeserializer() {
        super(Order.class);
    }
}
