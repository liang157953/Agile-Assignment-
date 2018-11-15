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
public class CorporateCustomer extends Customer{
     private double creditLimit;
     private double creditAmount;
     private String status;

    public CorporateCustomer() {
    }

    public CorporateCustomer(double creditLimit, double creditAmount, String status, String custID, String custName, String custAddress, String custContactNo) {
        super(custID, custName, custAddress, custContactNo);
        this.creditLimit = creditLimit;
        this.creditAmount = creditAmount;
        this.status = status;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CorporateCustomer{" + "creditLimit=" + creditLimit + ", creditAmount=" + creditAmount + ", status=" + status + '}';
    }
}
