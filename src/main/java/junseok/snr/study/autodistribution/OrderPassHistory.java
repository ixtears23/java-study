package junseok.snr.study.autodistribution;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderPassHistory {
    private Integer seqOrderPassHistory;
    private int seqOrderInfo;
    private int seqOrderPass;
    private int price;
    private int salePrice;
    private int sumCardAmount;
    private int sumCashAmount;
    private int sumTransferAmount;
    private int paymentAmount;
    private int receivables;
    private LocalDateTime paymentDatetime;

}
