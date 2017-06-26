package com.moji4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

class ConversionTable {

    private static final String ROMAJI_TO_KATAKANA_FILE = "/romaji_to_katakana.csv";
    private static final String ROMAJI_TO_HIRAGANA_FILE = "/romaji_to_hiragana.csv";
    private static final String KANA_TO_ROMAJI_FILE = "/kana_to_romaji.csv";

    private static ConversionTable romajiToKatakanaTable;
    private static ConversionTable romajiToHiraganaTable;
    private static ConversionTable kanaToRomajiTable;

    private Map<String, String> conversionMap;
    private int maxKeyLength;

    private ConversionTable(Map<String, String> conversionMap) {
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

    public static synchronized ConversionTable getRomajiToKatakana() {

        if (romajiToKatakanaTable == null) {
            romajiToKatakanaTable = createConversionTableFromResource(ROMAJI_TO_KATAKANA_FILE);
        }

        return romajiToKatakanaTable;
    }

    public static synchronized ConversionTable getRomajiToHiragana() {

        if (romajiToHiraganaTable == null) {
            romajiToHiraganaTable = createConversionTableFromResource(ROMAJI_TO_HIRAGANA_FILE);
        }

        return romajiToHiraganaTable;
    }

    public static synchronized ConversionTable getKanaToRomaji() {

        if (kanaToRomajiTable == null) {
            kanaToRomajiTable = createConversionTableFromResource(KANA_TO_ROMAJI_FILE);
        }

        return kanaToRomajiTable;
    }

    private static ConversionTable createConversionTableFromResource(String resourceName) {

        URL resourceUrl = ConversionTable.class.getResource(resourceName);

        try (InputStream inputStream = resourceUrl.openStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Map<String, String> conversionMap = new TreeMap<String, String>();

            String line;
            while ((line = reader.readLine()) != null) {

                int delimiterIndex = line.indexOf(',');

                String key = line.substring(0, delimiterIndex);
                String value = line.substring(delimiterIndex + 1);

                conversionMap.put(key, value);
            }

            return new ConversionTable(conversionMap);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
