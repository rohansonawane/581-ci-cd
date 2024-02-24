import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMathUtil {

private MathUtils mathUtils;
	
	

	@Test
	void test() {
		
	}
	
	@BeforeEach
    public void setUp() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    public void tearDown() {
       
    }

    @Test
    public void testAdd() {
        assertEquals(5, mathUtils.add(2, 3));
        assertEquals(-1, mathUtils.add(-2, 1));
       
        assertEquals(3, mathUtils.add(1, 2));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, mathUtils.subtract(4, 3));
        assertEquals(-5, mathUtils.subtract(2, 7));
        
    }

    @Test
    public void testMultiply() {
        assertEquals(6, mathUtils.multiply(2, 3));
        assertEquals(0, mathUtils.multiply(0, 5));
        
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, mathUtils.divide(5, 2), 0.001); // Specify delta for double comparisons
        assertEquals(-2.0, mathUtils.divide(10, -5), 0.001);
        assertEquals(-1.0, mathUtils.divide(0, 0), 0.001); // Division by zero
   }


}
