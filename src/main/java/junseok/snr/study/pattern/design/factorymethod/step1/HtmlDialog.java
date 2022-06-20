package junseok.snr.study.pattern.design.factorymethod.step1;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
