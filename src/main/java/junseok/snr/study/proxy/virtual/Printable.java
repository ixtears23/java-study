package junseok.snr.study.proxy.virtual;

public interface Printable {
    String getPrinterName();
    void setPrinterName(String name);
    void print(String str);
}
