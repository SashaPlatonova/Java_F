package lesson6;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MainArraysTest extends TestCase {

    @Test
    public void testModifiedArr() {
        int[] expectedArr = {1,3,5,6};
        int[] arr = MainArrays.modifiedArr(new int[]{4, 1, 3, 5, 6});
        int[] arr1 = MainArrays.modifiedArr(new int[]{1, 4, 6, 4, 1, 3, 5, 6});
        int[] arr2 = MainArrays.modifiedArr(new int[]{4, 1, 4, 1, 3, 5, 6});
        int[] arr3 = MainArrays.modifiedArr(new int[]{4, 5, 5, 4});

        assertTrue(Arrays.equals(expectedArr, arr));
        assertTrue(Arrays.equals(expectedArr, arr1));
        assertTrue(Arrays.equals(expectedArr, arr2));
        assertTrue(Arrays.equals(new int[] {}, arr3));
        try {
            int[] arr4 = MainArrays.modifiedArr(new int[]{0, 1, 3, 5, 6});
            Assert.fail("Exsepted RTE");
        }catch (RuntimeException e){

        }
    }
    @Test
    public void testOneFourInArr() {
        assertTrue(MainArrays.oneFourInArr(new int[] {1, 4, 1, 4, 1, 1}));
        assertFalse(MainArrays.oneFourInArr(new int[]{1, 1, 1, 1, 1}));
        assertFalse(MainArrays.oneFourInArr(new int[]{4, 4, 4, 4, 4}));
        assertFalse(MainArrays.oneFourInArr(new int[]{1, 1, 4, 3, 4}));
    }
}