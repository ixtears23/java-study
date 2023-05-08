package junseok.snr.study.autodistribution;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AutoDistribution {
    private final List<OrderPass> orderPassList;
    private final List<OrderPayment> orderPaymentList;
    private List<OrderPassHistory> orderPassHistoryList;

    // 자동 변환
    public void autoDistribute() {
    }
}
