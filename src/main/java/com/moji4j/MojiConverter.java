package com.moji4j;

public class MojiConverter {
    private static final int MAX_ROMAJI_KEY_LENGTH = 3;

    public String convertRomajiToKatakana(String romajiString) {

        romajiString = romajiString.toLowerCase();
        StringBuilder katakanaBuilder = new StringBuilder();

        int currentOffset = 0;
        int substringLength = MAX_ROMAJI_KEY_LENGTH;

        while (currentOffset < romajiString.length()) {

            if (currentOffset + substringLength <= romajiString.length()) {

                String romajiSubstring = romajiString.substring(currentOffset, currentOffset + substringLength);
                String katakanaString = MojiConversionTable.ROMAJI_TO_KATAKANA.get(romajiSubstring);

                if (katakanaString != null) {
                    katakanaBuilder.append(katakanaString);

                    currentOffset += romajiSubstring.length();
                    substringLength = MAX_ROMAJI_KEY_LENGTH;

                    continue;

                } else if (substringLength == 1) {
                    katakanaBuilder.append(romajiSubstring);

                    currentOffset += 1;
                    substringLength = MAX_ROMAJI_KEY_LENGTH;

                    continue;
                }
            }

            substringLength -= 1;
        }

        return katakanaBuilder.toString();
    }

    public String convertRomajiToHiragana(String string) {

        return null;
    }
}
