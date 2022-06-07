package junseok.snr.study.pattern.design.factorymethod;

public class WindowDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
