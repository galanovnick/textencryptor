package encryptor;

import encryptor.impl.StringConverter;
import encryptor.impl.TranspositionStringConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class TranspositionStringConverterTest {

    private final StringConverter converter = new encryptor.impl.TranspositionStringConverter();

    private final List<String> strings = new ArrayList<>(Arrays.asList("feed", "thed", "og"));

    private final List<String> expected = new ArrayList<>(Arrays.asList("fto", "ehg", "ee", "dd"));

    @Test
    public void testSimpleStringsConverting() {
        assertEquals("Converting of simple strings failed.", expected, converter.transform(strings));
    }

    @Test
    public void testLastSymbolsConverting() {
        assertEquals("Converting of last symbols failed.", expected, converter.transform(strings));
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

                return converter.transform(strings);
            }));
        }

        for (Future<List<String >> elem : results) {
            assertEquals(expected, elem.get());
        }
    }
}
