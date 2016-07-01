package encryptor;

import encryptor.impl.TextParserImpl;
import encryptor.impl.TextParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextGridParserTest {

    private final TextParser parsers = new TextParserImpl();

    @Test
    public void testSimpleSentenceParsing() {

        final List<String> expected = new ArrayList<>(Arrays.asList("have", "anic", "eday"));

        assertEquals("Parsing of simple sentence failed.", expected, parsers.analyze("have a nice day"));
    }
}
