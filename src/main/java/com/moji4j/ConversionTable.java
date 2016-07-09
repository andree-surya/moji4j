package com.moji4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

class ConversionTable {
    private static ConversionTable ROMAJI_TO_KATAKANA;
    private static ConversionTable ROMAJI_TO_HIRAGANA;

    private Map<String, String> map;
    private int maxKeyLength;

    ConversionTable(Map<String, String> map) {
        this.map = map;

        for (String key : map.keySet()) {

            if (key.length() > maxKeyLength) {
                maxKeyLength = key.length();
            }
        }
    }

    int getMaxKeyLength() {
        return maxKeyLength;
    }

    String get(String key) {
        return map.get(key);
    }

    static ConversionTable getConversionTableForMode(ConversionMode mode) {

        switch (mode) {
            case ROMAJI_TO_KATAKANA:

                if (ROMAJI_TO_KATAKANA == null) {
                    ROMAJI_TO_KATAKANA = new ConversionTable(readConversionMapFromResource("/romaji_to_katakana.csv"));
                }

                return ROMAJI_TO_KATAKANA;

            case ROMAJI_TO_HIRAGANA:

                if (ROMAJI_TO_HIRAGANA == null) {
                    ROMAJI_TO_HIRAGANA = new ConversionTable(readConversionMapFromResource("/romaji_to_hiragana.csv"));
                }

                return ROMAJI_TO_HIRAGANA;
        }

        return null;
    }

    private static Map<String, String> readConversionMapFromResource(String resourceName) {

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

        return conversionMap;
    }
}
