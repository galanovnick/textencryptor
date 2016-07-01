package encryptor.impl;

import java.util.List;

/**
 * Interface for strings transformation.
 */
public interface StringConverter {

    /**
     * Returns transformed list of strings.
     * @param strings - strings to be transformed.
     * @return list of strings
     */
    List<String> transform(List<String> strings);
}
