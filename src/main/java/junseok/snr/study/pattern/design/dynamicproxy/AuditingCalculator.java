package junseok.snr.study.pattern.design.dynamicproxy;

public class AuditingCalculator implements Calculator {
    private Calculator inner;
    private Auditor auditor;

    public AuditingCalculator(Calculator inner, Auditor auditor) {
        this.inner = inner;
        this.auditor = auditor;
    }

    @Override
    public int add(int left, int right) {
        auditor.audit("calculator", "before add");
        int result = inner.add(left, right);
        auditor.audit("calculator", "after add");
        return result;
    }
}
