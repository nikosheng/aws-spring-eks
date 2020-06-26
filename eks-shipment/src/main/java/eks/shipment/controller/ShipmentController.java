package eks.shipment.controller;

import eks.shipment.model.Shipment;
import eks.shipment.model.vo.ShipmentVO;
import eks.shipment.service.ShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class ShipmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/shipment/get/{shipmentId}")
    public ShipmentVO getShipment(@PathVariable Long shipmentId) {
        LOGGER.info("getShipment - {}", shipmentId);

        Shipment shipment = shipmentService.findShipmentById(shipmentId);
        ShipmentVO shipmentVO = null;
        try {
            shipmentVO = ShipmentVO.ShipmentVOBuilder.newBuilder()
                    .ip(InetAddress.getLocalHost().getHostAddress())
                    .orderId(shipment.getOrderId())
                    .customerId(shipment.getCustomerId())
                    .itemId(shipment.getItemId())
                    .shipmentId(shipment.getShipmentId())
                    .shipmentAddress(shipment.getShipmentAddress()).build();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return shipmentVO;
    }

    @GetMapping("/shipment/list")
    public List<Shipment> listShipments() {
        LOGGER.info("listShipments");

        List<Shipment> shipments = shipmentService.listShipments();
        return shipments;
    }

    @PostMapping("/shipment/save")
    public void saveShipment(@RequestBody @NotNull Shipment shipment) {

        LOGGER.info("saveShipment - {}", shipment.getShipmentId());

        shipmentService.createShipment(shipment);
    }
}
