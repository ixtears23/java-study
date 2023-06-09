package junseok.snr.study.java.api.textblock;

public class TextBlocks {

    private static final String NAME_TWO = """
            Oh
            Junseok
            """;
    private final String nameOne = """
            O
            NI
            """;

    public String getNameOne() {
        return nameOne;
    }

    public static String getNameTwo() {
        return NAME_TWO;
    }

    public String getName(String name) {
        return name;
    }
}
