package leetcode;

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix == null || matrix.length == 0) return ans;
		int rowStart = 0;
		int colStart = 0;
		int rowEnd = matrix.length - 1;
		int colEnd = matrix[0].length - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			// go right
			for (int i = colStart;i <= colEnd;i++) {
				ans.add(matrix[rowStart][i]);
			}
			rowStart++;
			
			// go down
			for (int i = rowStart; i <= rowEnd;i++) {
				ans.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			//go left
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					ans.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}
			
			// go up
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart;i--) {
					ans.add(matrix[i][colStart]);
				}
				colStart++;
			}
 		}
		return ans;
		
	}


	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(new SpiralMatrix().spiralOrder(matrix));

	}

}
