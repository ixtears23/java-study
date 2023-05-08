package junseok.snr.study.autodistribution;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OrderPass {
    private int seqOrderInfo;
    private int seqOrderPass;
    private int price;
    private int salePrice;
    private int paymentAmount;
    private int receivables;

}
