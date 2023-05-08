package junseok.snr.study.autodistribution;

import java.util.List;

public class AutoDistribution {
    private final List<OrderPass> orderPassList;
    private final List<OrderPayment> orderPaymentList;
    private final List<OrderPassHistory> orderPassHistoryList;

    public AutoDistribution(List<OrderPass> orderPassList, List<OrderPayment> orderPaymentList, List<OrderPassHistory> orderPassHistoryList) {
        this.orderPassList = orderPassList;
        this.orderPaymentList = orderPaymentList;
        this.orderPassHistoryList = orderPassHistoryList;
    }

    public void autoDistribute() {

        int paymentAmount = 0;
        int receivables = 0;


        for (OrderPass orderPass : orderPassList) {

        }

    }



}
