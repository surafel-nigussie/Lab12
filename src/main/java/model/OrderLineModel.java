package model;

public class OrderLineModel {
    private ProductModel productModel;
    private int quantity;
    private String batch;

    public OrderLineModel() {

    }

    public OrderLineModel(ProductModel productModel, int quantity, String batch) {
        this.productModel = productModel;
        this.quantity = quantity;
        this.batch = batch;
    }

    public ProductModel getProduct() {
        return productModel;
    }

    public void setProduct(ProductModel productModel) {
        this.productModel = productModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
