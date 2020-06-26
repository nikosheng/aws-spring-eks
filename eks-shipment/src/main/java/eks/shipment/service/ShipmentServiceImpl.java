package eks.shipment.service;

import com.alibaba.fastjson.JSONObject;
import eks.shipment.dao.ShipmentRepository;
import eks.shipment.model.Shipment;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @Transactional
    public void createShipment(@NotNull(message = "The shipment cannot be null.") @Valid Shipment shipment) {
        shipment.setCreateTimestamp(Date.from(Instant.now()));
        shipment.setUpdateTimestamp(Date.from(Instant.now()));
        shipmentRepository.save(shipment);

        ProducerRecord<String, String> record =
                new ProducerRecord<>("aws.topic.order.test", JSONObject.toJSONString(shipment));
        kafkaTemplate.send(record);
    }

    @Override
    @Transactional
    public void updateShipment(@NotNull(message = "The shipment cannot be null.") @Valid Shipment shipment) {
        shipment.setUpdateTimestamp(Date.from(Instant.now()));
        shipmentRepository.save(shipment);
    }

    @Override
    public Shipment findShipmentById(Long shipmentId) {
        return shipmentRepository.findById(shipmentId).orElse(Shipment.ShipmentBuilder.newBuilder().emptyShipment());
    }

    @Override
    public List<Shipment> listShipments() {
        return shipmentRepository.findAll();
    }
}
