package com.moji4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

class ConversionTable {
    static ConversionTable ROMAJI_TO_KATAKANA;
    static ConversionTable ROMAJI_TO_HIRAGANA;
    static ConversionTable KANA_TO_ROMAJI;

    static {
        ROMAJI_TO_KATAKANA = createConversionTableFromResource("/romaji_to_katakana.csv");
        ROMAJI_TO_HIRAGANA = createConversionTableFromResource("/romaji_to_hiragana.csv");
        KANA_TO_ROMAJI = createConversionTableFromResource("/kana_to_romaji.csv");
    }

    private Map<String, String> conversionMap;
    private int maxKeyLength;

    ConversionTable(Map<String, String> conversionMap) {
        this.conversionMap = conversionMap;

        for (String key : conversionMap.keySet()) {

            if (key.length() > maxKeyLength) {
                maxKeyLength = key.length();
            }
        }
    }

    int getMaxKeyLength() {
        return maxKeyLength;
    }

    String get(String key) {
        return conversionMap.get(key);
    }

    private static ConversionTable createConversionTableFromResource(String resourceName) {

        URL resourceUrl = ConversionTable.class.getResource(resourceName);
        Map<String, String> conversionMap = new TreeMap<String, String>();

        InputStream inputStream = null;

        try {
            inputStream = resourceUrl.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {

                int delimiterIndex = line.indexOf(',');

                String key = line.substring(0, delimiterIndex);
                String value = line.substring(delimiterIndex + 1);

                conversionMap.put(key, value);
            }

        } catch (IOException exception) {
            throw new RuntimeException(exception);

        } finally {

            if (inputStream == null) {
                try {
                    inputStream.close();

                } catch (IOException exception) {
                    throw new RuntimeException(exception);

                }
            }
        }

        return new ConversionTable(conversionMap);
    }
}
