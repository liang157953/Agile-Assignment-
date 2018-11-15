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
public class Accessories {
    private String accID;
    private String accDesc;
    private double accPrice;

    public Accessories() {
    }

    public Accessories(String accID, String accDesc, double accPrice) {
        this.accID = accID;
        this.accDesc = accDesc;
        this.accPrice = accPrice;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getAccDesc() {
        return accDesc;
    }

    public void setAccDesc(String accDesc) {
        this.accDesc = accDesc;
    }

    public double getAccPrice() {
        return accPrice;
    }

    public void setAccPrice(double accPrice) {
        this.accPrice = accPrice;
    }

    @Override
    public String toString() {
        return "Accessories{" + "accID=" + accID + ", accDesc=" + accDesc + ", accPrice=" + accPrice + '}';
    }
}
