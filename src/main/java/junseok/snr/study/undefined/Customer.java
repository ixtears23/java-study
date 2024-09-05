package junseok.snr.study.undefined;

public class Customer implements Nullable {
    @Override
    public boolean isNull() {
        return false;
    }
    protected Customer() {}

    public String getName() {
        return null;
    }

    public BillingPlan getPlan() {
        return new BillingPlan();
    }

    public PaymentHistory getHistory() {
        return new PaymentHistory();
    }
}
