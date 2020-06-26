package eks.user.model.serde;

import eks.user.model.Shipment;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {

    public ShipmentDeserializer() {
        super(Shipment.class);
    }
}
