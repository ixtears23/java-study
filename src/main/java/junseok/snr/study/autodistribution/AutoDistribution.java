package junseok.snr.study.autodistribution;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class AutoDistribution {

    /**
     * 2개의 파라미터 리스트는 잘 작성되어야 한다.
     *
     * @param orderPassList
     * @param orderPaymentList
     * @return
     */
    public List<OrderPassHistory> autoDistribute(final List<OrderPass> orderPassList, final List<OrderPayment> orderPaymentList) {
        // 결과 목록
        final List<OrderPassHistory> orderPassHistoryList = new ArrayList<>();

        // 날짜 별 orderPaymentList
        // 여기에 있는 paymentAmount는 로직이 종료되면 반드시 모두 0 값 이어야 한다.
        final List<DateGroupedOrderPayment> dateGroupedOrderPaymentList = createDateGroupedOrderPayment(orderPaymentList);

        // orderPass 결제 금액(paymentAmount)
        // 이 결제금액을 차감해 나가야 한다.
        // 차감 대상 금액
        final int[] orderPassPaymentAmountArray = new int[orderPassList.size()];
        for (int i = 0; i < orderPassList.size(); i++) {
            orderPassPaymentAmountArray[i] = orderPassList.get(i).getPaymentAmount();
        }


        final int[] sumOrderPassAmountList = new int[orderPassList.size()];

        for (int i = 0; i < dateGroupedOrderPaymentList.size(); i++) {
            final DateGroupedOrderPayment orderPayment = dateGroupedOrderPaymentList.get(i);

            int currentPaymentAmount  = orderPayment.getPaymentAmount();

            if (i > 0) currentPaymentAmount -= dateGroupedOrderPaymentList.get(i - 1).getPaymentAmount();

            for (int j = 0; j < orderPassList.size(); j++) {
                final OrderPass orderPass = orderPassList.get(j);
                int newPaymentAmount = 0;

                if (currentPaymentAmount != 0) {
                    if (orderPassPaymentAmountArray[j] >= currentPaymentAmount) {
                        newPaymentAmount = currentPaymentAmount;
                        currentPaymentAmount = 0;
                        orderPassPaymentAmountArray[j] -= newPaymentAmount;
                    } else if (orderPassPaymentAmountArray[j] < currentPaymentAmount) {
                        newPaymentAmount = orderPassPaymentAmountArray[j];
                        orderPassPaymentAmountArray[j] = 0;
                        currentPaymentAmount -= newPaymentAmount;
                    }
                    sumOrderPassAmountList[j] += newPaymentAmount;
                }

                orderPassHistoryList.add(
                        OrderPassHistory.builder()
                                .seqOrderPassHistory(null)
                                .seqOrderInfo(orderPass.getSeqOrderInfo())
                                .seqOrderPass(orderPass.getSeqOrderPass())
                                .price(orderPass.getPrice())
                                .salePrice(orderPass.getSalePrice())
                                .sumCardAmount(orderPayment.sumCardAmount)
                                .sumTransferAmount(orderPayment.sumTransferAmount)
                                .sumCashAmount(orderPayment.sumCashAmount)
                                .receivables(orderPass.getSalePrice()- sumOrderPassAmountList[j])
                                .paymentAmount(sumOrderPassAmountList[j])
                                .paymentDatetime(orderPayment.paymentDateTime)
                                .build()
                );
            }
        }

        return orderPassHistoryList;
    }


    /**
     * order_payment에 있는 목록에서, payment_datetime을 기준으로 그룹핑!
     * 카드 수단은 중요하지 않고, 날짜 별로 row가 존재한다.
     * 그리고 Grouping된 나머지 값들은 다 SUM
     * @param orderPaymentList
     * @return
     */
    private List<DateGroupedOrderPayment> createDateGroupedOrderPayment(List<OrderPayment> orderPaymentList) {
        final List<DateGroupedOrderPayment> dateGroupedOrderPaymentList = new ArrayList<>();

        Map<LocalDateTime, List<OrderPayment>> groupedOrderPayments = orderPaymentList.stream()
                .collect(Collectors.groupingBy(OrderPayment::getPaymentDatetime));

        final Map<LocalDateTime, List<OrderPayment>> sortedGroupedOrderPaymentList = new TreeMap<>(groupedOrderPayments);

        int sumCardAmount = 0;
        int sumCashAmount = 0;
        int sumTransferAmount = 0;

        for (Map.Entry<LocalDateTime, List<OrderPayment>> entry : sortedGroupedOrderPaymentList.entrySet()) {

            final LocalDateTime paymentDatetime = entry.getKey();

            for (OrderPayment orderPayment : entry.getValue()) {
                switch (orderPayment.getPaymentType()) {
                    case CARD:
                        sumCardAmount += orderPayment.getPaymentAmount();
                        break;
                    case CASH:
                        sumCashAmount += orderPayment.getPaymentAmount();
                        break;
                    case TRANSFER:
                        sumTransferAmount += orderPayment.getPaymentAmount();
                        break;
                }
            }


            dateGroupedOrderPaymentList.add(
                    new DateGroupedOrderPayment(
                            sumCardAmount,
                            sumCashAmount,
                            sumTransferAmount,
                            paymentDatetime,
                            sumCardAmount + sumCashAmount + sumTransferAmount
                    )
            );
        }

        return dateGroupedOrderPaymentList;
    }

    private static class DateGroupedOrderPayment {
        private final int sumCardAmount;
        private final int sumCashAmount;
        private final int sumTransferAmount;
        private final LocalDateTime paymentDateTime;
        private final int paymentAmount;

        public DateGroupedOrderPayment(int sumCardAmount, int sumCashAmount, int sumTransferAmount, LocalDateTime paymentDateTime, int paymentAmount) {
            this.sumCardAmount = sumCardAmount;
            this.sumCashAmount = sumCashAmount;
            this.sumTransferAmount = sumTransferAmount;
            this.paymentDateTime = paymentDateTime;
            this.paymentAmount = paymentAmount;
        }

        public int getPaymentAmount() {
            return paymentAmount;
        }

        public LocalDateTime getPaymentDateTime() {
            return paymentDateTime;
        }
    }
}
