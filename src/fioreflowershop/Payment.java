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
public class Payment {
    private String paymentID;
    private String paymentDate;
    private double totalAmount;
    private String paymentStatus;

    public Payment() {
    }

    public Payment(String paymentID, String paymentDate, double totalAmount, String paymentStatus) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", totalAmount=" + totalAmount + ", paymentStatus=" + paymentStatus + '}';
    }
}
