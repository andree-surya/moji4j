package com.moji4j;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class MojiDetectorTest {

    private MojiDetector detector;

    @Before
    public void setUp() {
        detector = new MojiDetector();
    }

    @Test
    public void shouldTellIfTextHasKanji() {
        assertTrue(detector.hasKanji("まっ暗"));
        assertTrue(detector.hasKanji("飲んじゃった"));
        assertTrue(detector.hasKanji("ウソ付き"));
        assertFalse(detector.hasKanji("まっしろ"));
        assertFalse(detector.hasKanji("クリスマス"));
        assertFalse(detector.hasKanji("souiukotoka"));
    }

    @Test
    public void shouldTellIfTextHasKana() {
        assertTrue(detector.hasKana("飲みたくない"));
        assertTrue(detector.hasKana("もうヨパラって"));
        assertTrue(detector.hasKana("ジャストアウェー"));
        assertFalse(detector.hasKana("健康保険"));
        assertFalse(detector.hasKana("soiukotodayo"));
    }

    @Test
    public void shouldTellIfTextHasRomaji() {
        assertTrue(detector.hasRomaji("Latin"));
        assertTrue(detector.hasRomaji("モデル XYZ"));
        assertFalse(detector.hasRomaji("飛んでもない"));
        assertFalse(detector.hasRomaji("ロシア"));
    }

    @Test
    public void shouldTellIfCharacterIsKanji() {
        assertTrue(detector.isKanji('爆'));
        assertTrue(detector.isKanji('食'));
        assertFalse(detector.isKanji('ー'));
        assertFalse(detector.isKanji('か'));
        assertFalse(detector.isKanji('ナ'));
        assertFalse(detector.isKanji('a'));
        assertFalse(detector.isKanji('"'));
    }

    @Test
    public void shouldTellIfCharacterIsKana() {
        assertTrue(detector.isKana('あ'));
        assertTrue(detector.isKana('ワ'));
        assertTrue(detector.isKana('っ'));
        assertTrue(detector.isKana('ー'));
        assertFalse(detector.isKana('.'));
        assertFalse(detector.isKana('。'));
    }

    @Test
    public void shouldTellIfCharacterIsRomaji() {
        assertTrue(detector.isRomaji('a'));
        assertTrue(detector.isRomaji('Z'));
        assertFalse(detector.isRomaji(' '));
        assertFalse(detector.isRomaji('じ'));
        assertFalse(detector.isRomaji('字'));
    }
}
