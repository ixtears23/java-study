package junseok.snr.study.pattern.design.factorymethod.step1;

public class WindowDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
