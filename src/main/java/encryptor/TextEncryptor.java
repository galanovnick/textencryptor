package encryptor;

/**
 * Interface for text encryption.
 */
public interface TextEncryptor {

    /**
     * Returns encrypted text.
     * @param text - text to be encrypted.
     * @return encrypted text.
     */
    String encrypt(String text);
}
