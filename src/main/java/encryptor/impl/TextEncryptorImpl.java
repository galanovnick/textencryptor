package encryptor.impl;

import encryptor.TextEncryptor;

import java.util.List;

public class TextEncryptorImpl implements TextEncryptor {

    private final TextParser parser = new TextGridParser();
    private final StringConverter converter = new StringGridConverter();

    @Override
    public String encrypt(String text) {
        List<String> processedParts = converter.transform(parser.analyze(text));

        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < processedParts.size(); i++) {
            resultString.append(processedParts.get(i));
            if (i < processedParts.size() - 1) {
                resultString.append(" ");
            }
        }

        return resultString.toString();
    }
}
