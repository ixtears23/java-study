package domain.product;

import domain.order.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Product {
    private Integer productId;
    private Order order;

    protected void createOrder() {
        log.info("=== Product.createOrder()");

    };
}
