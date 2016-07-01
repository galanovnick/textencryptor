package encryptor.impl;

import java.util.ArrayList;
import java.util.List;

public class TextGridParser implements TextParser {

    @Override
    public List<String> analyze(String text) {
        final char[] textChars = text.replaceAll(" ", "").toCharArray();
        final List<String> resultStrings = new ArrayList<>();
        final int stringSize = (int) Math.ceil(Math.sqrt(textChars.length));

        StringBuilder string = new StringBuilder();
        for (int i = 1; i <= textChars.length; i++) {
            string.append(textChars[i-1]);

            if (i % stringSize == 0 || i == textChars.length) {
                resultStrings.add(string.toString());
                string.delete(0, string.length());
            }
        }

        return resultStrings;
    }
}
