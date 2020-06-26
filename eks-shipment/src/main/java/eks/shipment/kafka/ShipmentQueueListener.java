package eks.shipment.kafka;

import com.alibaba.fastjson.JSONObject;
import eks.shipment.model.Order;
import eks.shipment.model.Shipment;
import eks.shipment.service.ShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ShipmentQueueListener {

    private final Logger log = LoggerFactory.getLogger(ShipmentQueueListener.class);

    public ShipmentQueueListener(){}

    @Autowired
    private ShipmentService shipmentService;

    @KafkaListener(topics = "aws.topic.shipment.test")
    public void order(String orderJson) {
        Order order = JSONObject.parseObject(orderJson, Order.class);
        log.info("Received order " + order.getOrderId());
        Shipment shipment = Shipment.ShipmentBuilder
                .newBuilder()
                .orderId(order.getOrderId())
                .itemId(order.getItemId())
                .customerId(order.getCustomerId())
                .shipmentAddress(order.getShipmentAddress())
                .build();
        shipmentService.createShipment(shipment);
    }
}
