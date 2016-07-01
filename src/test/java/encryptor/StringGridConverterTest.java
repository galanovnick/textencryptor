package encryptor;

import encryptor.impl.StringConverter;
import encryptor.impl.StringGridConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringGridConverterTest {

    private final StringConverter converter = new StringGridConverter();

    @Test
    public void testSimpleStringsConverting() {
        final List<String> strings = new ArrayList<>(Arrays.asList("hav", "ean", "ice", "day"));

        final List<String> expected = new ArrayList<>(Arrays.asList("hae", "and", "via", "ecy"));

        assertEquals("Converting of simple strings failed.", expected, converter.transform(strings));
    }
}
