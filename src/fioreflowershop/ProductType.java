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
public class ProductType {
    private String productTypeID;
    private String productTypeName; 
    private String productTypeDesc;

    public ProductType() {
    }

    public ProductType(String productTypeID, String productTypeName, String productTypeDesc) {
        this.productTypeID = productTypeID;
        this.productTypeName = productTypeName;
        this.productTypeDesc = productTypeDesc;
    }

    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
    }

    public String getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(String productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @Override
    public String toString() {
        return "ProductType{" + "productTypeID=" + productTypeID + ", productTypeName=" + productTypeName + ", productTypeDesc=" + productTypeDesc + '}';
    }
}
