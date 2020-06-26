package eks.shipment.model.serde;

import eks.shipment.model.Shipment;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {

    public ShipmentDeserializer() {
        super(Shipment.class);
    }
}
