/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop;

public class PickUp {
    private String pickupNo;
    private String pickupDate;
    private String pickupTime;
    private String pickupStatus;
    private Staff staff;
    private Order order;

    public PickUp() {
    }

    public PickUp(String pickupNo, String pickupDate, String pickupTime, String pickupStatus, Staff staff, Order order) {
        this.pickupNo = pickupNo;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.pickupStatus = pickupStatus;
        this.staff = staff;
        this.order = order;
    }

    public String getPickupNo() {
        return pickupNo;
    }

    public void setPickupNo(String pickupNo) {
        this.pickupNo = pickupNo;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getPickupStatus() {
        return pickupStatus;
    }

    public void setPickupStatus(String pickupStatus) {
        this.pickupStatus = pickupStatus;
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
        return "PickUp{" + "pickupNo=" + pickupNo + ", pickupDate=" + pickupDate + ", pickupTime=" + pickupTime + ", pickupStatus=" + pickupStatus + ", staff=" + staff + ", order=" + order + '}';
    }
}
