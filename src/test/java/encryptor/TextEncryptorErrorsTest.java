package encryptor;

import encryptor.impl.TextEncryptorImpl;
import org.junit.Test;

public class TextEncryptorErrorsTest {

    private final TextEncryptor encryptor = new TextEncryptorImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyText() {
        encryptor.encrypt("  ");
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        encryptor.encrypt(null);
    }
}
