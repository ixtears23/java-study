package junseok.snr.study.java.api.textblock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextBlocksTest {
    private static final String NAME_TWO = """
            Oh
            Junseok
            """;
    private final String nameOne = """
            O
            NI
            """;

    @Test
    void getNameOneTest() {
        final TextBlocks textBlocks = new TextBlocks();
        final String nameOne = textBlocks.getNameOne();

        assertEquals(this.nameOne, nameOne);
    }

    @Test
    void getNameTwo() {
        final String nameTwo = TextBlocks.getNameTwo();

        assertEquals(NAME_TWO, nameTwo);
    }

    @Test
    void getNameTest() {

        final TextBlocks textBlocks = new TextBlocks();
        final String nameOne = textBlocks.getName(this.nameOne);
        final String nameTwo = textBlocks.getName(NAME_TWO);

        assertEquals(this.nameOne, nameOne);
        assertEquals(NAME_TWO, nameTwo);
    }
}