package encryptor;

/**
 * Interface for encrypting text.
 */
public interface TextEncryptor {

    /**
     * Returns encrypted text.
     * @param text - text to be encrypted.
     * @return encrypted text.
     */
    String encrypt(String text);
}
