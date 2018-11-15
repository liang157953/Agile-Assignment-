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
public class Style {
    private String styleID;
    private String styleDesc;
    private double stylePrice;

    public Style() {
    }

    public Style(String styleID, String styleDesc, double stylePrice) {
        this.styleID = styleID;
        this.styleDesc = styleDesc;
        this.stylePrice = stylePrice;
    }

    public String getStyleID() {
        return styleID;
    }

    public void setStyleID(String styleID) {
        this.styleID = styleID;
    }

    public String getStyleDesc() {
        return styleDesc;
    }

    public void setStyleDesc(String styleDesc) {
        this.styleDesc = styleDesc;
    }

    public double getStylePrice() {
        return stylePrice;
    }

    public void setStylePrice(double stylePrice) {
        this.stylePrice = stylePrice;
    }

    @Override
    public String toString() {
        return "Style{" + "styleID=" + styleID + ", styleDesc=" + styleDesc + ", stylePrice=" + stylePrice + '}';
    }
}
