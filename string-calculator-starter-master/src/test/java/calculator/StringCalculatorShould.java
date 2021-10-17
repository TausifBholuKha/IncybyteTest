package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

	@Test
	void empty_string_should_return_0() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	void string_with_two_number_should_return_sum() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	void string_with_two_number_should_return_newline_sum() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("1,2,3"));
	}

	@Test
	void string_with_add_number_using_newline_should_sum() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}

	@Test
	public void string_with_negative_number_should_exception() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		stringCalculator.add("-1");
		stringCalculator.add("-1,-5,-8,-35");
	}

	@Test
	void string_with_ignore_greaterthan_1000() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(1031, stringCalculator.add("10,20,1001"));
	}
	
	@Test
	void string_with_support_diff_delimiter() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("//;\n1;2"));
	}
	
//	@Test
//	void string_with_delimeter_any_lengh() throws Exception {
//		StringCalculator stringCalculator = new StringCalculator();
//		assertEquals(6, stringCalculator.abc("//[***]\n1***2***3"));
//	}
}
