package practise;

// June
public class GreatCommonDivisor {
	public static int getGCD(int val1, int val2) {
		while(val1 != 0 && val2 != 0) {
			if(val1 > val2) {
				val1 = val1 % val2;
			}else {
				val2 = val2 % val1;
			}
		}
		return val1 + val2;
	}
	
	public static void main(String[] args) {
		System.out.println(getGCD(1, 99));
		System.out.println(getGCD(0,  99));
		System.out.println(getGCD(1071, 462));
	}
}
