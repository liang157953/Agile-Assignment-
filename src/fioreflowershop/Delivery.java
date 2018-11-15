/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop;

/**
 *
 * @author User
 */
public class Delivery {
    private String trackingNo;
    private String deliveryAddress;
    private String deliveryContactNo;
    private String requireDeliveryDate;
    private String requireDeliveryTime;
    private String arrivalDate;
    private String arrivalTime;
    private String deliveryStatus;
    private Staff staff;
    private Order order;
    private int priorityLevel;

    public Delivery() {
    }

    public Delivery(String trackingNo, String deliveryAddress, String deliveryContactNo, String requireDeliveryDate, String requireDeliveryTime, String arrivalDate, String arrivalTime, String deliveryStatus, Staff staff, Order order, int priorityLevel) {
        this.trackingNo = trackingNo;
        this.deliveryAddress = deliveryAddress;
        this.deliveryContactNo = deliveryContactNo;
        this.requireDeliveryDate = requireDeliveryDate;
        this.requireDeliveryTime = requireDeliveryTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.deliveryStatus = deliveryStatus;
        this.staff = staff;
        this.order = order;
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryContactNo() {
        return deliveryContactNo;
    }

    public void setDeliveryContactNo(String deliveryContactNo) {
        this.deliveryContactNo = deliveryContactNo;
    }

    public String getRequireDeliveryDate() {
        return requireDeliveryDate;
    }

    public void setRequireDeliveryDate(String requireDeliveryDate) {
        this.requireDeliveryDate = requireDeliveryDate;
    }

    public String getRequireDeliveryTime() {
        return requireDeliveryTime;
    }

    public void setRequireDeliveryTime(String requireDeliveryTime) {
        this.requireDeliveryTime = requireDeliveryTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Delivery{" + "trackingNo=" + trackingNo + ", deliveryAddress=" + deliveryAddress + ", deliveryContactNo=" + deliveryContactNo + ", requireDeliveryDate=" + requireDeliveryDate + ", requireDeliveryTime=" + requireDeliveryTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", deliveryStatus=" + deliveryStatus + ", staff=" + staff + ", order=" + order + ", priorityLevel=" + priorityLevel + '}';
    }
}
