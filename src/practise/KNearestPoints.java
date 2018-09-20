package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// important
public class KNearestPoints {
	public static void main(String []args) {
		List<List<Integer>> locations = new ArrayList<>();
		locations.add(Arrays.asList(5, 5));
		locations.add(Arrays.asList(2, 6));
		locations.add(Arrays.asList(7, 3));
		locations.add(Arrays.asList(1, 1));
		locations.add(Arrays.asList(10, 1));
		locations.add(Arrays.asList(5, 7));
		locations.add(Arrays.asList(9, 9));
		locations.add(Arrays.asList(4, 9));
		locations.add(Arrays.asList(8, 8));
		locations.add(Arrays.asList(2, 6));
		List<Integer> user = Arrays.asList(0, 0);
		int k = 3;
		
		printResult(findKNearestLocations(locations, user, k));
	}
	
	public static List<List<Integer>> findKNearestLocations(List<List<Integer>> locations, List<Integer> user, int k){
		List<List<Integer>> result = new ArrayList<>();
//		class Point{
//			double x;
//			double y;
//			Point(double x, double y){
//				this.x = x;
//				this.y = y;
//			}
//		}
		PriorityQueue<List<Integer>> q = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				double d1 = getDistance(o1, user);
				double d2 = getDistance(o2, user);
				return d1 < d2 ? 1 : (d1 == d2 ? 0 : -1);
			}
		});
		
		for(List<Integer> location : locations) {
			if(q.size() < k) {
				q.add(location);
//				System.out.println("location in1 : " + location.get(0) + ", " + location.get(1));
				continue;
			}
			if(getDistance(location, user) < getDistance(q.peek(), user)) {
				List<Integer> out = q.remove();
//				System.out.println("location out : " + out.get(0) + ", " + out.get(1));
				q.add(location);
//				System.out.println("location in2 : " + location.get(0) + ", " + location.get(1));
			}
		}
		
		while(!q.isEmpty()) {
			result.add(q.poll());
		}
		
		return result;
	}
	
	public static double getDistance(List<Integer> l1, List<Integer> l2) {
		return Math.sqrt(Math.pow(l1.get(0) - l2.get(0), 2) + Math.pow(l1.get(1) - l2.get(1), 2));
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
