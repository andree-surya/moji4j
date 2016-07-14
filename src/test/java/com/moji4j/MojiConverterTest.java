package com.moji4j;

import org.junit.Before;
import org.junit.Test;

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
        assertEquals("ジェット", converter.convertRomajiToHiragana("jetto"));
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
        assertEquals("じょうだん", converter.convertRomajiToHiragana("joudan"));
    }

    @Test
    public void shouldConvertKatakanaToRomaji() {
        assertEquals("katakana", converter.convertKanaToRomaji("カタカナ"));
        assertEquals("honkon", converter.convertKanaToRomaji("ホンコン"));
        assertEquals("konbaataa", converter.convertKanaToRomaji("コンバーター"));
        assertEquals("doraggu", converter.convertKanaToRomaji("ドラッグ"));
        assertEquals("messhu", converter.convertKanaToRomaji("メッシュ"));
        assertEquals("feisubukku", converter.convertKanaToRomaji("フェイスブック"));
        assertEquals("paathii", converter.convertKanaToRomaji("パーティー"));
        assertEquals("jetto", converter.convertKanaToRomaji("ジェット"));
    }

    @Test
    public void shouldConvertHiraganaToRomaji() {
        assertEquals("hiragana", converter.convertKanaToRomaji("ひらがな"));
        assertEquals("shinbashi", converter.convertKanaToRomaji("しんばし"));
        assertEquals("obaasan", converter.convertKanaToRomaji("おばあさん"));
        assertEquals("makkura", converter.convertKanaToRomaji("まっくら"));
        assertEquals("matcha", converter.convertKanaToRomaji("まっちゃ"));
        assertEquals("hikitsudzuki", converter.convertKanaToRomaji("ひきつづき"));
        assertEquals("sorawotobu", converter.convertKanaToRomaji("そらをとぶ"));
        assertEquals("annai", converter.convertKanaToRomaji("あんない"));
        assertEquals("kan'i", converter.convertKanaToRomaji("かんい"));
        assertEquals("nan'yakan'ya", converter.convertKanaToRomaji("なんやかんや"));
        assertEquals("joudan", converter.convertKanaToRomaji("じょうだん"));
    }
}
