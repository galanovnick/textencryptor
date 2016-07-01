package encryptor.impl;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class StringGridConverter implements StringConverter {

    @Override
    public List<String> transform(List<String> strings) {
        final List<StringBuilder> resultStrings = new ArrayList<>();
        for (int i = 0; i < strings.get(0).length(); i++) {
            resultStrings.add(new StringBuilder());
        }

        strings.forEach((string) -> {
            char[] stringChars = string.toCharArray();
            for (int i = 0; i < stringChars.length; i++) {
                resultStrings.get(i).append(stringChars[i]);
            }
        });

        return Lists.transform(resultStrings, StringBuilder::toString);
    }
}
