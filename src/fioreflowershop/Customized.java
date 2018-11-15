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
public class Customized {
    private String customizedID;
    private Product product;
    private Size size;
    private Style style;
    private Accessories accessories;
    private Order order;

    public Customized() {
    }

    public Customized(String customizedID, Product product, Size size, Style style, Accessories accessories, Order order) {
        this.customizedID = customizedID;
        this.product = product;
        this.size = size;
        this.style = style;
        this.accessories = accessories;
        this.order = order;
    }

    public String getCustomizedID() {
        return customizedID;
    }

    public void setCustomizedID(String customizedID) {
        this.customizedID = customizedID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories accessories) {
        this.accessories = accessories;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customized{" + "customizedID=" + customizedID + ", product=" + product + ", size=" + size + ", style=" + style + ", accessories=" + accessories + ", order=" + order + '}';
    }
}
