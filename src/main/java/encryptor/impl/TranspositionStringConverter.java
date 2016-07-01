package encryptor.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implements strings formatting using rule of matrix transposition.
 *
 * a b c d    a e i
 * e f g h -> b f j
 * i j k l    c g k
 *            d h l
 */
public class TranspositionStringConverter implements StringConverter {

    private final Logger log = LoggerFactory.getLogger(TranspositionStringConverter.class);

    /**
     * Returns transformed strings.
     * @param strings - strings to be transformed.
     * @return list of strings.
     */
    @Override
    public List<String> transform(List<String> strings) {
        checkNotNull(strings, "Expected not null list.");
        checkArgument(strings.size() > 0, "Expected not empty list.");

        if (log.isDebugEnabled()) {
            log.debug("Transforming...");
        }

        final List<StringBuilder> resultStrings = new ArrayList<>();

        final int resultStringNumber = strings.get(0).length();

        for (int i = 0; i < resultStringNumber; i++) {
            resultStrings.add(new StringBuilder());
        }

        strings.forEach((string) -> {
            final char[] stringChars = string.toCharArray();
            for (int i = 0; i < stringChars.length; i++) {
                resultStrings.get(i).append(stringChars[i]);
            }
        });

        if (log.isDebugEnabled()) {
            log.debug("Transforming done");
        }

        /**
         * Transform into list of Strings using guava.
         */
        return Lists.transform(resultStrings, StringBuilder::toString);
    }
}
