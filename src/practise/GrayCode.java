package practise;

public class GrayCode {
	public static boolean isGrayCode(byte term1, byte term2) {
		byte tmp = (byte)(term1 ^ term2);
		int count = 0;
		while(tmp != 0) {
			tmp = (byte)(tmp & (tmp - 1));
			count ++;
		}
		return count == 1 ? true : false;
	}
	
	public static void main(String []args) {
		
	}
}
