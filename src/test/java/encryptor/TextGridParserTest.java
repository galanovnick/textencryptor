package encryptor;

import encryptor.impl.TextParserImpl;
import encryptor.impl.TextParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class TextGridParserTest {

    private final TextParser parsers = new TextParserImpl();

    private final List<String> expected = new ArrayList<>(Arrays.asList("have", "anic", "eday"));

    @Test
    public void testSimpleSentenceParsing() {
        assertEquals("Parsing of simple sentence failed.", expected, parsers.analyze("have a nice day"));
    }

    @Test
    public void testThreadSafety() throws ExecutionException, InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(50);

        final List<Future<List<String>>> results = new ArrayList<>();

        final CountDownLatch countDown = new CountDownLatch(50);

        for (int i = 0; i < 50; i++) {
            results.add(executor.submit(() -> {

                countDown.countDown();
                countDown.await();

                return parsers.analyze("have a nice day");
            }));
        }

        for (Future<List<String >> elem : results) {
            assertEquals(expected, elem.get());
        }
    }
}
