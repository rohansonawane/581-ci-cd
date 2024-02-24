
public class MathUtils {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public double divide(int a, int b) {
        // Check for division by zero
        if (b == 0) {
            System.err.println("Error: Division by zero is not allowed.");
            return -1.0;
        }

        // Perform the division
        return (double) a / b;
    }
}
