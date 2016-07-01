package encryptor.impl;

import java.util.List;

/**
 * Interface for transforming strings.
 */
public interface StringConverter {

    /**
     * Returns transformed list of strings.
     * @param strings - strings to be transformed.
     * @return list of strings
     */
    List<String> transform(List<String> strings);
}
