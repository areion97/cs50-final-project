package com.santaclaus.model;

import com.santaclaus.enumeration.DeliveryStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private List<Present> presentList;
    private DeliveryStatus deliveryStatus = DeliveryStatus.NOT_PREPARED;

    public void setPresentList(List<Present> presentList) {
        this.presentList = presentList;
    }

    // The checks prevent moving statuses from one to another without any logic reason
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        if((DeliveryStatus.IN_PREPARATION.name().equals(deliveryStatus.name()) && DeliveryStatus.NOT_PREPARED.name().equals(this.deliveryStatus.name()))
           || (DeliveryStatus.IN_DELIVERY.name().equals(deliveryStatus.name()) && DeliveryStatus.IN_PREPARATION.name().equals(this.deliveryStatus.name()))
           || (DeliveryStatus.DELIVERED.name().equals(deliveryStatus.name()) && DeliveryStatus.IN_DELIVERY.name().equals(this.deliveryStatus.name()))
        ) {
            this.deliveryStatus = deliveryStatus;
        }
    }

    // Add getter for presentList
    public List<Present> getPresentList() {
        return presentList;
    }

    // Add getter for deliveryStatus
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }
}

