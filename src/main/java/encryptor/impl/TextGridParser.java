package encryptor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implements text parsing in a list of strings with fixed length.
 */
public class TextGridParser implements TextParser {

    private final Logger log = LoggerFactory.getLogger(TextGridParser.class);

    /**
     * Returns parsed list of strings.
     * @param text - text to be parsed.
     * @return list of strings.
     */
    @Override
    public List<String> analyze(String text) {
        checkNotNull(text, "Expected not null.");
        checkArgument(text.length() > 0, "Expected not empty string.");

        if (log.isDebugEnabled()) {
            log.debug("Parsing...");
        }

        final char[] textChars = text.replaceAll(" ", "").toCharArray();
        final List<String> resultStrings = new ArrayList<>();
        /**
         * Fixed result strings length based on input text size.
         */
        final int stringSize = (int) Math.ceil(Math.sqrt(textChars.length));

        final StringBuilder string = new StringBuilder();
        for (int i = 1; i <= textChars.length; i++) {
            string.append(textChars[i-1]);

            if (i % stringSize == 0 || i == textChars.length) {
                resultStrings.add(string.toString());
                string.delete(0, string.length());
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Parsing done");
        }

        return resultStrings;
    }
}
