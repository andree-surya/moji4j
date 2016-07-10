package com.moji4j;

public class MojiDetector {

    public boolean hasKana(String string) {

        for (char c : string.toCharArray()) {

            if (isKana(c)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasKanji(String string) {

        for (char c : string.toCharArray()) {

            if (isKanji(c)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasLatin(String string) {

        for (char c : string.toCharArray()) {

            if (isLatin(c)) {
                return true;
            }
        }

        return false;
    }

    private boolean isKana(char c) {
        Character.UnicodeBlock b = Character.UnicodeBlock.of(c);

        return (b == Character.UnicodeBlock.HIRAGANA ||
                b == Character.UnicodeBlock.KATAKANA ||
                b == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
    }

    private boolean isKanji(char c) {
        return (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
    }

    private boolean isLatin(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}
