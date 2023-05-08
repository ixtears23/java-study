package junseok.snr.study.autodistribution;

public class OrderPassHistory {
    int seqOrderPassHistory;
    int seqOrderInfo;
    int seqOrderPass;
    int price;
    int salePrice;
    int paymentAmount;
    int receivables;

    public OrderPassHistory(int seqOrderPassHistory, int seqOrderInfo, int seqOrderPass, int price, int salePrice, int paymentAmount, int receivables) {
        this.seqOrderPassHistory = seqOrderPassHistory;
        this.seqOrderInfo = seqOrderInfo;
        this.seqOrderPass = seqOrderPass;
        this.price = price;
        this.salePrice = salePrice;
        this.paymentAmount = paymentAmount;
        this.receivables = receivables;
    }
}
