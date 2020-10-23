package lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XOTest {

    @Before
    public void init() {
        XO.fillMap(4);
    }

    @Test
    public void test1() {
        XO.move(0,0, 'X');
        XO.move(0,1, 'X');
        XO.move(0,2, 'X');
        Assert.assertTrue(!XO.isVictory('X'));
    }

    @Test
    public void test2() {
        XO.move(0,0, 'X');
        XO.move(1,0, 'X');
        XO.move(2,0, 'X');
        Assert.assertTrue(!XO.isVictory('X'));
    }

    @Test
    public void test3() {
        XO.move(0,0, 'X');
        XO.move(1,1, 'X');
        XO.move(2,2, 'X');
        Assert.assertTrue(!XO.isVictory('X'));
    }
}
