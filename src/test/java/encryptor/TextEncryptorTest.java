package encryptor;

import encryptor.impl.TextEncryptorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TextEncryptorTest {

    private final TextEncryptor encryptor = new TextEncryptorImpl();
    private final String sentence = "if man was meant to stay on the ground god would have given us roots";

    @Test
    public void smokeTest() {
        assertNotNull("Smoke test failed.", encryptor.encrypt(sentence));
    }

    @Test
    public void testSimpleSentenceEncryption() {
        assertEquals("Encryption of simple sentence failed.", "hae and via ecy",
                encryptor.encrypt("have a nice day"));
    }

    @Test
    public void testLastSymbolsEncryption() {
        assertEquals("Encryption of last symbols failed.", "fto ehg ee dd",
                "feed the dog");
    }
}
