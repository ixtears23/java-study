package junseok.snr.study.autodistribution;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class OrderPayment {
    private int seqOrderInfo;
    private int seqOrderPayment;
    private PaymentType paymentType;
    private int paymentAmount;
    private LocalDateTime paymentDatetime;
}
