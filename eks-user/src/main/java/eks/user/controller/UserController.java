package eks.user.controller;

import eks.user.model.Shipment;
import eks.user.model.vo.OrderVO;
import eks.user.util.MapBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${variables.shipment.uri:http://localhost:8001}")
    private String shipmentHost;

    @Value("${variables.order.uri:http://localhost:8000}")
    private String orderHost;

    @GetMapping("/eks/user/{userId}/order/{orderId}")
    public OrderVO getOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        LOGGER.info("User {} getOrder - {}", userId, orderId);
        LOGGER.info("OrderHost: {}", orderHost);

        OrderVO order = null;
        if (userId != null) {
            ResponseEntity<OrderVO> responseEntity = restTemplate.getForEntity(
                    orderHost + "/api/v1/order/get/{orderId}",
                    OrderVO.class, new MapBuilder.Builder<Long>().map("orderId", orderId).build().map());
            order = responseEntity.getBody();
        }
        return order;
    }

    @GetMapping("/eks/user/{userId}/shipment/{shipmentId}")
    public Shipment getShipment(@PathVariable Long userId, @PathVariable Long shipmentId) {
        LOGGER.info("User {} getShipment - {}", userId, shipmentId);
        LOGGER.info("ShipmentHost: {}", shipmentHost);

        Shipment shipment = null;
        if (userId != null) {
            ResponseEntity<Shipment> responseEntity = restTemplate.getForEntity(
                    orderHost + "/api/v1/shipment/get/{shipmentId}",
                    Shipment.class, new MapBuilder.Builder<Long>().map("shipmentId", shipmentId).build().map());
            shipment = responseEntity.getBody();
        }
        return shipment;
    }
}
