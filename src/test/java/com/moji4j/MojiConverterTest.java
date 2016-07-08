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


    }
}
