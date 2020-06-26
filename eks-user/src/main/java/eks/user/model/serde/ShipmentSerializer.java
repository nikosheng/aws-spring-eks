package eks.user.model.serde;

import eks.user.model.Shipment;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ShipmentSerializer extends JsonSerializer<Shipment> {
}
