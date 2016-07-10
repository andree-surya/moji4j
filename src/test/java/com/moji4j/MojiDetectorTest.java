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
    public void shouldTellIfTextHasLatin() {
        assertTrue(detector.hasLatin("Latin"));
        assertTrue(detector.hasLatin("モデル XYZ"));
        assertFalse(detector.hasLatin("飛んでもない"));
        assertFalse(detector.hasLatin("ロシア"));
    }
}
