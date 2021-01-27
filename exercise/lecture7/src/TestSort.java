import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    // test method should not be static
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
//        for (int i = 0; i < input.length; i++) {
//            if (!input[i].equals(expected[i])) {
//                System.out.println("Error: mismatching in position " + i + ", expected: " + expected[i] +
//                        " but got: " + input[i]);
//                return;
//            }
//        }
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }

//    public static void main(String[] args) {
//        testFindSmallest();
//        testSwap();
//        testSort();
//    }
}
