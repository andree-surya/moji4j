package com.moji4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class MojiConverterTest {

    private MojiConverter converter;

    @Before
    public void setUp() {
        converter = new MojiConverter();
    }

    @Test
    public void shouldConvertRomajiToKatakana() {

        assertEquals("カタカナ", converter.convertRomajiToKatakana("katakana"));
        assertEquals("カタカナ", converter.convertRomajiToKatakana("KATAKANA"));
        assertEquals("ホンコン", converter.convertRomajiToKatakana("honkon"));
        assertEquals("コンバーター", converter.convertRomajiToKatakana("konba-ta-"));
        assertEquals("コンバーター", converter.convertRomajiToKatakana("konbaataa"));
        assertEquals("ドラッグ", converter.convertRomajiToKatakana("doraggu"));
        assertEquals("メッシュ", converter.convertRomajiToKatakana("messhu"));
        assertEquals("フェイスブック", converter.convertRomajiToKatakana("feisubukku"));
        assertEquals("パーティー", converter.convertRomajiToKatakana("paathii"));
    }

    @Test
    public void shouldConvertRomajiToHiragana() {
        
        assertEquals("ひらがな", converter.convertRomajiToHiragana("hiragana"));
        assertEquals("ひらがな", converter.convertRomajiToHiragana("HIRAGANA"));
        assertEquals("しんばし", converter.convertRomajiToHiragana("shinbashi"));
        assertEquals("しんばし", converter.convertRomajiToHiragana("shimbashi"));
        assertEquals("おばあさん", converter.convertRomajiToHiragana("obaasan"));
        assertEquals("まっくら", converter.convertRomajiToHiragana("makkura"));
        assertEquals("まっちゃ", converter.convertRomajiToHiragana("maccha"));
        assertEquals("まっちゃ", converter.convertRomajiToHiragana("matcha"));
        assertEquals("ひきつづき", converter.convertRomajiToHiragana("hikitsuduki"));
        assertEquals("ひきつづき", converter.convertRomajiToHiragana("hikitsudzuki"));
        assertEquals("そらをとぶ", converter.convertRomajiToHiragana("sorawotobu"));
        assertEquals("なんやかんや", converter.convertRomajiToHiragana("nan'yakan'ya"));
    }
}
