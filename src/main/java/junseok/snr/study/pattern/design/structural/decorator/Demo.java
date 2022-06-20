package junseok.snr.study.pattern.design.structural.decorator;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name, Salary\nJhon Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressDecorator(
                new EncryptionDecorator(
                        new FileDataSource("/Users/ohjunseok/out/OutputDemo.txt")
                )
        );
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("/Users/ohjunseok/out/OutputDemo.txt");

        System.out.println("- Input --------------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded ------------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded ------------------");
        System.out.println(encoded.readData());
    }
}
