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
public class Delivery implements DeliveryInterface{
    private String trackingNo;
    private String deliveryAddress;
    private String state;
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

    public Delivery(String trackingNo, String deliveryAddress, String state, String deliveryContactNo, String requireDeliveryDate, String requireDeliveryTime, String arrivalDate, String arrivalTime, String deliveryStatus, Staff staff, Order order, int priorityLevel) {
        this.trackingNo = trackingNo;
        this.deliveryAddress = deliveryAddress;
        this.state = state;
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
  
     public Delivery getDelivery() {
       Delivery delivery = new Delivery(this.trackingNo, this.deliveryAddress, this.state, this.deliveryContactNo, this.requireDeliveryDate, this.requireDeliveryTime, this.arrivalDate, this.arrivalTime, this.deliveryStatus,this.staff,this.order,this.priorityLevel);
        return delivery;
     }
    public String getTrackingNo() {
        return trackingNo;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getState() {
        return state;
    }

    public String getDeliveryContactNo() {
        return deliveryContactNo;
    }

    public String getRequireDeliveryDate() {
        return requireDeliveryDate;
    }

    public String getRequireDeliveryTime() {
        return requireDeliveryTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public Staff getStaff() {
        return staff;
    }

    public Order getOrder() {
        return order;
    }

//    public int getPriorityLevel() {
//        return priorityLevel;
//    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDeliveryContactNo(String deliveryContactNo) {
        this.deliveryContactNo = deliveryContactNo;
    }

    public void setRequireDeliveryDate(String requireDeliveryDate) {
        this.requireDeliveryDate = requireDeliveryDate;
    }

    public void setRequireDeliveryTime(String requireDeliveryTime) {
        this.requireDeliveryTime = requireDeliveryTime;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public void setPriorityLevel(int priorityLevel) {
//        this.priorityLevel = priorityLevel;
//    }

//    @Override
//    public String toString() {
//        return "Delivery{" + "trackingNo=" + trackingNo + ", deliveryAddress=" + deliveryAddress + ", state=" + state + ", deliveryContactNo=" + deliveryContactNo + ", requireDeliveryDate=" + requireDeliveryDate + ", requireDeliveryTime=" + requireDeliveryTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", deliveryStatus=" + deliveryStatus + ", staff=" + staff + ", order=" + order + ", priorityLevel=" + priorityLevel + '}';
//    }
        public int compareTo(DeliveryInterface other) {
        return this.getRequireDeliveryTime().compareTo(other.getDelivery().getRequireDeliveryTime());
    }
    @Override
    public String toString() {
        return "Delivery{" + "trackingNo=" + trackingNo + ", deliveryAddress=" + deliveryAddress + ", state=" + state + ", deliveryContactNo=" + deliveryContactNo + ", requireDeliveryDate=" + requireDeliveryDate + ", requireDeliveryTime=" + requireDeliveryTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", deliveryStatus=" + deliveryStatus + ", staff=" + staff + ", order=" + order + '}';
    }
    
    

    
}