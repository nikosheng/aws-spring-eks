package eks.shipment.model.vo;

import eks.shipment.model.Shipment;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ShipmentVO {
    private String ip;

    private Long shipmentId;

    private Long customerId;

    private Long itemId;

    private Long orderId;

    private String shipmentAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;

    private Date updateTimestamp;

    public ShipmentVO(){}

    public ShipmentVO(Long shipmentId, Long customerId, Long itemId, Long orderId, String shipmentAddress, Date createTimestamp, Date updateTimestamp) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.shipmentId = shipmentId;
        this.shipmentAddress = shipmentAddress;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public ShipmentVO(ShipmentVOBuilder builder) {
        this.ip = builder.ip;
        this.shipmentId = builder.shipmentId;
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.itemId = builder.itemId;
        this.shipmentAddress = builder.shipmentAddress;
        this.createTimestamp = builder.createTimestamp;
        this.updateTimestamp = builder.updateTimestamp;
    }

    public static class ShipmentVOBuilder {
        private String ip;
        private Long shipmentId;
        private Long orderId;
        private Long customerId;
        private Long itemId;
        private String shipmentAddress;
        private Date createTimestamp;
        private Date updateTimestamp;

        public static ShipmentVOBuilder newBuilder(){
            return new ShipmentVOBuilder();
        }
        public ShipmentVO build(){
            return new ShipmentVO(this);
        }

        public ShipmentVOBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public ShipmentVOBuilder shipmentId(Long shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public ShipmentVOBuilder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public ShipmentVOBuilder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public ShipmentVOBuilder itemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public ShipmentVOBuilder shipmentAddress(String shipmentAddress) {
            this.shipmentAddress = shipmentAddress;
            return this;
        }

        public ShipmentVOBuilder createTimestamp(Date createTimestamp) {
            this.createTimestamp = createTimestamp;
            return this;
        }

        public ShipmentVOBuilder updateTimestamp(Date updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public Shipment emptyShipment() {
            return new Shipment(0L, 0L, 0L, 0L, null, new Date(), new Date());
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
