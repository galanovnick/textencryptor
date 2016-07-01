package encryptor.impl;

import java.util.List;

/**
 * Interface for parsing text in a list of strings.
 */
public interface TextParser {

    /**
     * Returns list of strings.
     * @param text - text to be parsed.
     * @return list of strings
     */
    List<String> analyze(String text);
}
