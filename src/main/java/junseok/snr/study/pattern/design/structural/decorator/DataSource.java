package junseok.snr.study.pattern.design.structural.decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}
