package jobportal;

import java.util.Random;

public class OTPGenerator {

	public static void main(String[] args) {
//		String.format("%06d", 6);
//
//		
//	}
//	public static String getRandomNumberString() {
//		// It will generate 6 digit random Number.
//		// from 0 to 999999
//		Random rnd = new Random();
//		int number = rnd.nextInt(999999);
//		System.out.println(number);
//		// this will convert any number sequence into 6 character.
//		return String.format("%06d", number);
//	}
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		System.out.println(number);
	}

}
