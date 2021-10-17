package calculator;

import java.util.Arrays;
import java.util.stream.Stream;

class StringCalculator {
	private String delimiter = ",|\n";
	
	public int add(String input) throws Exception {
		String[] num = input.split(delimiter);
		
		if (input.isEmpty()) {
			return 0;
		}
		if (input.length() == 1) {
			return Integer.parseInt(input);
		}
		if(input.startsWith("//")) {
			String[] str = input.split("\n",2);
			delimiter = str[0].substring(2);
			input = str[1];
		}
		
		else {
			return multipleSum(num);
		}
		Stream<String> supdel = Arrays.stream(input.split(delimiter));
		return supdel.mapToInt(Integer::parseInt).sum();
	}

	private int multipleSum(String[] num) throws Exception {
		findNegative(num);
		return greaterthanthousand(num);
	}

	private int greaterthanthousand(String[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			if (i >= 1000) {
				continue;
			}
			sum = sum + Integer.parseInt(num[i]);
		}
		return sum;
	}
	private void findNegative(String[] num) throws Exception {
		for (int i = 0; i < num.length; i++) {
			if (i < 0) {
				throw new Exception("negatives not allowed");
			}
		}
	}
	
//	public String abc(String header) {
//		String strdel = header.substring(2);
//		if(strdel.startsWith("[")) {
//			strdel = strdel.substring(1 , strdel.length()-1);
//		}
//		return Pattern.quote(strdel);
//	}
}