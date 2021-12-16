package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

	/**
	 * return i ^ n for positive Integer, None otherwise
	 * alse return None in case of errors
	 */
	public static Option<Integer> power(Integer i, Integer n) {
		
		// Manage negative Integer as requested
		if(i < 0 || n < 0) {
			return Option.none();
		}
		
		Option<Integer> optInt;
		try {
			Integer powerResult = 1;
			if (i > 0 && n == 0) {
				powerResult = 1;
			} else if (i == 0 && n >= 1) {
				powerResult = 0;
			} else {
				for(int iter = 1; iter <= n; iter++) {
					powerResult = Math.multiplyExact(powerResult, i);
				}
			}
			optInt = Option.of(powerResult);
		} catch (ArithmeticException e) {
			// Manage Underflow & Overflow
			optInt = Option.none();
		}
		
		return optInt;
	}
}
