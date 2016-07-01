package encryptor.impl;

import encryptor.TextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implements text encryption using rule of matrix transposition (@see TranspositionStringConverter).
 */
public class TextEncryptorImpl implements TextEncryptor {

    private final Logger log = LoggerFactory.getLogger(TextEncryptorImpl.class);

    private final TextParser parser = new TextParserImpl();
    private final StringConverter converter = new TranspositionStringConverter();

    /**
     * Returns encrypted text.
     * @param text - text to be encrypted.
     * @return - encrypted text.
     */
    @Override
    public String encrypt(String text) {

        checkNotNull(text, "Expected not null string.");
        checkArgument(text.length() > 0, "Expected not empty string.");

        if (log.isDebugEnabled()) {
            log.debug("Encrypting text: \"" + text + "\"");
        }

        final List<String> processedParts = converter.transform(parser.analyze(text));

        final StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < processedParts.size(); i++) {
            resultString.append(processedParts.get(i));
            if (i < processedParts.size() - 1) {
                resultString.append(" ");
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Encrypting done: \"" + resultString.toString() + "\"");
        }
        return resultString.toString();
    }
}
