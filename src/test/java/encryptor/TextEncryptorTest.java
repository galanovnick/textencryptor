package encryptor;

import encryptor.impl.TextEncryptorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextEncryptorTest {

    private final TextEncryptor encryptor = new TextEncryptorImpl();

    @Test
    public void testComplexSentenceEncryption() {
        final String sentence = "if man was meant to stay on the ground god would have given us roots";

        final String expected = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";

        assertEquals("Encryption of complex sentence failed.", expected, encryptor.encrypt(sentence));
    }

    @Test
    public void testSimpleSentenceEncryption() {
        assertEquals("Encryption of simple sentence failed.", "hae and via ecy",
                encryptor.encrypt("have a nice day"));
    }

    @Test
    public void testLastSymbolsEncryption() {
        assertEquals("Encryption of last symbols failed.", "fto ehg ee dd",
                encryptor.encrypt("feed the dog"));
    }

    @Test
    public void testOneSymbolEncryption() {
        assertEquals("Encryption of ine symbol failed.", "a",
                encryptor.encrypt("a"));
    }

    @Test
    public void testWhitspacesEncryption() {
        assertEquals("Encryption of ine symbol failed.", "fto ehg ee dd",
                encryptor.encrypt("    feed   the                  dog"));
    }
}
