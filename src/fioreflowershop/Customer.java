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
public class Customer {
    private String custID;
    private String custName;
    private String custAddress;
    private String custContactNo;

    public Customer() {
    }

    public Customer(String custID, String custName, String custAddress, String custContactNo) {
        this.custID = custID;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custContactNo = custContactNo;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustContactNo() {
        return custContactNo;
    }

    public void setCustContactNo(String custContactNo) {
        this.custContactNo = custContactNo;
    }

    @Override
    public String toString() {
        return "Customer{" + "custID=" + custID + ", custName=" + custName + ", custAddress=" + custAddress + ", custContactNo=" + custContactNo + '}';
    }
}
