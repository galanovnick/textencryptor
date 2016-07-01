package encryptor;

import encryptor.impl.StringConverter;
import encryptor.impl.TranspositionStringConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringGridConverterTest {

    private final StringConverter converter = new TranspositionStringConverter();

    @Test
    public void testSimpleStringsConverting() {
        final List<String> strings = new ArrayList<>(Arrays.asList("have", "anic", "eday"));

        final List<String> expected = new ArrayList<>(Arrays.asList("hae", "and", "via", "ecy"));

        assertEquals("Converting of simple strings failed.", expected, converter.transform(strings));
    }

    @Test
    public void testLastSymbolsConvertion() {
        final List<String> strings = new ArrayList<>(Arrays.asList("feed", "thed", "og"));

        final List<String> expected = new ArrayList<>(Arrays.asList("fto", "ehg", "ee", "dd"));

        assertEquals("Converting of last symbols failed.", expected, converter.transform(strings));
    }
}
