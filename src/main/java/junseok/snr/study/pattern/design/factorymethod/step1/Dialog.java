package junseok.snr.study.pattern.design.factorymethod.step1;

public abstract class Dialog {

    public void renderWindow() {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}
