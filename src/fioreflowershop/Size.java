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
public class Size {
    private String sizeID;
    private String sizeDesc;
    private double sizePrice;

    public Size() {
    }

    public Size(String sizeID, String sizeDesc, double sizePrice) {
        this.sizeID = sizeID;
        this.sizeDesc = sizeDesc;
        this.sizePrice = sizePrice;
    }

    public String getSizeID() {
        return sizeID;
    }

    public void setSizeID(String sizeID) {
        this.sizeID = sizeID;
    }

    public String getSizeDesc() {
        return sizeDesc;
    }

    public void setSizeDesc(String sizeDesc) {
        this.sizeDesc = sizeDesc;
    }

    public double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(double sizePrice) {
        this.sizePrice = sizePrice;
    }

    @Override
    public String toString() {
        return "Size{" + "sizeID=" + sizeID + ", sizeDesc=" + sizeDesc + ", sizePrice=" + sizePrice + '}';
    }
}
