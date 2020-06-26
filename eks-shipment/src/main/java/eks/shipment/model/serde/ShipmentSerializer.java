package eks.shipment.model.serde;

import eks.shipment.model.Shipment;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ShipmentSerializer extends JsonSerializer<Shipment> {
}
