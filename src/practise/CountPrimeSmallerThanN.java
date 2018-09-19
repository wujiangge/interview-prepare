package practise;

public class CountPrimeSmallerThanN {
	public static int countPrimeNum(int n) {
		if(n < 3) return 0;
		boolean []isPrime = new boolean[n];
		for(int i = 0; i < n - 1; i ++) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i < Math.sqrt(n); i ++) {
			if(!isPrime[i]) continue;
			int tmp = i;
//			System.out.println("i is " + i + "now");
			while((tmp += i) < n) {
				isPrime[tmp] = false;
//				System.out.println("set " + tmp + "prime as false");
			}
		}
		int count = 0;
		for(int i = 0; i < n - 1; i ++) {
			if(isPrime[i]) count ++;
		}
		return count;
	}
	
	public static void main(String []args) {
//		System.out.println(countPrimeNum(6));
//		System.out.println(countPrimeNum(9));
//		System.out.println(countPrimeNum(25));
//		System.out.println(countPrimeNum(77));
		System.out.println(countPrimeNum(100000));
	}
}
