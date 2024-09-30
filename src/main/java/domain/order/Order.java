package domain.order;

import domain.product.Product;
import domain.product.ProductOrder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Order extends ProductOrder {
    private int orderId;
    private List<Product> products;

    void createOrder() {
        log.info("=== Order.createOrder()");

        log.info("=== partner productOrderId : {}", getName());
    }

    public static void main(String[] args) {
        new Order().createOrder();
    }
}
