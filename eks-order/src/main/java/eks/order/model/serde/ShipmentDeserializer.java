package eks.order.model.serde;

import eks.order.model.Shipment;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {
    public ShipmentDeserializer() {
        super(Shipment.class);
    }
}
