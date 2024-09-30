package domain.product;

public class ProductOrder {
    int productOrderId;
    protected String name;

    int getProductOrderId() {
        return this.productOrderId;
    }

    protected String getName() {
        return name;
    }
}
