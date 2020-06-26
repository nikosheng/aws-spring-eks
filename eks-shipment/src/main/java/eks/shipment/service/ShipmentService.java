package eks.shipment.service;

import eks.shipment.model.Shipment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ShipmentService {
    void createShipment(@NotNull(message = "The shipment cannot be null.") @Valid Shipment shipment);

    void updateShipment(@NotNull(message = "The shipment cannot be null.") @Valid Shipment shipment);

    Shipment findShipmentById(Long shipmentId);

    List<Shipment> listShipments();
}
