package eks.order.model.serde;

import eks.order.model.Order;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class OrderSerializer extends JsonSerializer<Order> {

}
