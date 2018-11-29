package fioreflowershop;

import fioreflowershop.ProductType;

public class Product {
    private String productID;
    private String productName;
    private String productDesc;
    private String productColor;
    private double productPrice;
    private int productQuantity;
    private ProductType productType;

    public Product() {
    }

    public Product(String productID, String productName, String productDesc, String productColor, double productPrice, int productQuantity, ProductType productType) {
        this.productID = productID;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productColor = productColor;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productType = productType;
    }

    public String getProductDesc() {
        return productDesc;
    }
    
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productDesc=" + productDesc + ", productColor=" + productColor + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productType=" + productType + '}';
    }
}