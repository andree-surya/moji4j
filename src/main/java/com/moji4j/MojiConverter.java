package com.moji4j;

import java.util.Map;

public class MojiConverter {

    public String convertRomajiToKatakana(String string) {
        return convertString(string.toLowerCase(), ConversionMode.ROMAJI_TO_KATAKANA);
    }

    public String convertRomajiToHiragana(String string) {
        return convertString(string.toLowerCase(), ConversionMode.ROMAJI_TO_HIRAGANA);
    }

    private String convertString(String originalString, ConversionMode mode) {

        StringBuilder resultBuilder = new StringBuilder();
        ConversionTable conversionTable = ConversionTable.getConversionTableForMode(mode);

        int currentOffset = 0;

        while (currentOffset < originalString.length()) {
            char character = originalString.charAt(currentOffset);

            // Replace long vowel in katakana.
            if (mode == ConversionMode.ROMAJI_TO_KATAKANA &&
                    isRomanVowel(character) && currentOffset > 1) {

                char previousCharacter = originalString.charAt(currentOffset - 1);

                if (character == previousCharacter) {
                    resultBuilder.append('ー');

                    currentOffset += 1;
                    continue;
                }
            }

            // Replace double consonant with a sokuon marker.
            if ((mode == ConversionMode.ROMAJI_TO_KATAKANA || mode == ConversionMode.ROMAJI_TO_HIRAGANA) &&
                    isRomanConsonant(character) && currentOffset < originalString.length() - 1) {

                char nextCharacter = originalString.charAt(currentOffset + 1);

                if (character == nextCharacter || (character == 't' && nextCharacter == 'c')) {

                    if (mode == ConversionMode.ROMAJI_TO_KATAKANA) {
                        resultBuilder.append('ッ');

                    } else {
                        resultBuilder.append('っ');
                    }

                    currentOffset += 1;
                    continue;
                }
            }

            int substringLength = Math.min(conversionTable.getMaxKeyLength(), originalString.length() - currentOffset);

            while (substringLength > 0) {
                String substring = originalString.substring(currentOffset, currentOffset + substringLength);
                String replacementString = conversionTable.get(substring);

                // Replace substring if there's a proper mapping.
                if (replacementString != null) {
                    resultBuilder.append(replacementString);

                    currentOffset += substring.length();
                    break;
                }

                // Keep original character for unsuccessful mapping.
                if (substringLength == 1) {
                    resultBuilder.append(character);

                    currentOffset += 1;
                    break;
                }

                substringLength -= 1;
            }
        }

        return resultBuilder.toString();
    }

    private static boolean isRomanConsonant(char character) {
        return character >= 'a' && character <= 'z' && ! isRomanVowel(character);
    }

    private static boolean isRomanVowel(char character) {
        return character == 'a' || character == 'i' || character == 'u' || character == 'e' || character == 'o';
    }
}
