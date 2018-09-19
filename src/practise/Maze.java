package practise;

public class Maze {
	/*
	 * given a matrix, start from (0,0)
	 * val 0 represents wall, 1 represents road
	 * val 9 is end
	 * check if can find 9 or not
	 */
	
	public static boolean existPath(int[][]matrix, int row, int col, int flag[][]) {
		boolean exist = false;
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		if(matrix[row][col] == 9) return true;
		flag[row][col] = 1;
		if(!exist && row - 1 >= 0 && matrix[row - 1][col] != 0 && flag[row - 1][col] != 1) {
			exist = exist || existPath(matrix, row - 1, col, flag);
		}
		if(!exist && col - 1 >= 0 && matrix[row][col - 1] != 0 && flag[row][col - 1] != 1) {
			exist = exist || existPath(matrix, row, col - 1, flag);
		}
		if(!exist && row + 1 < rowSize && matrix[row + 1][col] != 0 && flag[row + 1][col] != 1) {
			exist = exist || existPath(matrix, row + 1, col, flag);
		}
		if(!exist && col + 1 < colSize && matrix[row][col + 1] != 0 && flag[row][col + 1] != 1) {
			exist = exist || existPath(matrix, row, col + 1, flag);
		}
		return exist;
	}
	
	
	public static void main(String[] args) {
		int[][]case1 = new int[][] {{0, 1, 0}, {1, 1, 9}};
		int[][]flag1 = new int[][] {{0, 0, 0}, {0, 0, 0}};
		int[][]case2 = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 0, 9}};
		int[][]flag2 = new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		System.out.println(existPath(case1, 0, 0, flag1));
		System.out.println(existPath(case2, 0, 0, flag2));
	}

}
