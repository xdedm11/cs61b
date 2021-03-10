package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i<10; i++){
            arb.enqueue(i+0.0);
        }
        for (double d:arb){
            System.out.println(d);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
//        TestArrayRingBuffer testarb = new TestArrayRingBuffer();
//        testarb.someTest();
    }
} 
