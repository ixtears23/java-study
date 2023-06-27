package junseok.snr.study.sync.domain;


import java.math.BigDecimal;
import java.util.List;

public class Order {
    private long id;
    private List<OrderItem> product;
    private BigDecimal amount;
}
