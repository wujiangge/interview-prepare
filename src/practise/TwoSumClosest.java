package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Sep.
//2sum，不超过target且尽可能大，要求输出所有pair
public class TwoSumClosest {
	public static void main(String []args) {
		List<List<Integer>> forwarding = new ArrayList<>(); 
		List<List<Integer>> returns = new ArrayList<>();
		forwarding.add(Arrays.asList(1, 1000));
		forwarding.add(Arrays.asList(2, 7000));
		forwarding.add(Arrays.asList(3, 12000));
		returns.add(Arrays.asList(1, 10000));
		returns.add(Arrays.asList(2, 9000));
		returns.add(Arrays.asList(3, 3000));
		returns.add(Arrays.asList(4, 2000));
		printResult(sumClosest(forwarding, returns, 11000));
	}
	
	public static List<List<Integer>> sumClosest(List<List<Integer>> forwarding, List<List<Integer>> returns, int m){
		Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(1) > o2.get(1) ? 1 : (o1.get(1) == o2.get(1) ? 0 : -1);
			}
		};
		forwarding.sort(cmp);
		returns.sort(cmp);
		
		int closest = 0;
		List<List<Integer>> result = new ArrayList<>();
		int i = 0, j = returns.size() - 1; 
		while(i < forwarding.size() && j >= 0) {
			int sum = forwarding.get(i).get(1) + returns.get(j).get(1);
			if(sum >= m) {
				j --;
			}else {
				if(m - sum < m - closest) {// closer
					closest = sum;
					result.clear();
					result.add(Arrays.asList(forwarding.get(i).get(0), returns.get(j).get(0)));
				}else if (m - sum == m - closest) {
					result.add(Arrays.asList(forwarding.get(i).get(0), returns.get(j).get(0)));
				}
				i ++;
			}
		}
		return result;
	}
	
	public static void printResult(List<List<Integer>> result) {
		for(List<Integer> list : result) {
			System.out.print("[");
			for(Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println("]");
		}
	}
}
