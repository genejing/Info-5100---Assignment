// use 1 and 0 represent openspace and barrier respectively, place 1 in S and F 

public class Maze {
	public String mazeSolution(int[][] maze,int[]start,int[]end) { 
		StringBuilder res = new StringBuilder("");
		int row = maze.length;
		int col = maze[0].length;
		boolean[][] used = new boolean[row][col];
		if (mazeBackTracking(maze,end,start[0],start[1],used,res)) {;
			return res.toString();
		} else {
			return "No solution found";
		}
			
	}
	public boolean mazeBackTracking(int[][] maze, int[] end,int row,int col,boolean[][] used,StringBuilder res) 
	{
		if (row == end[0] && col == end[1]) {
			return true;
		}
		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
			return false;
		}
		if (used[row][col] == true || maze[row][col] != 1) {
			return false;
		}
		used[row][col] = true;
		
		boolean right = mazeBackTracking(maze, end, row, col+1, used, res.append("R"));
		if (right) return true;
		res.setLength(res.length()-1);
		
		boolean left = mazeBackTracking(maze, end, row, col-1, used, res.append("L"));
		if (left) return true;
		res.setLength(res.length()-1);
		
		boolean up = mazeBackTracking(maze, end, row-1, col, used, res.append("U"));
		if (up) return true;
		res.setLength(res.length()-1);
		
		boolean down = mazeBackTracking(maze, end, row+1, col, used, res.append("D"));
		if (down) return true;
		res.setLength(res.length()-1);
		
		used[row][col] = false;
		return false;
	}
	
	
	public static void main(String[] args) {
		Maze test = new Maze();
		int[][] maze1 = {{1,0,0,0},{1,1,1,1},{0,0,0,1}};
		int[] start1 = {0,0};
		int[] end1 = {2,3};
		
		System.out.println(test.mazeSolution(maze1, start1,end1));
		
		
		int[][] maze2 = {{0,1,0,0,0,0,0},{0,1,1,1,1,1,0},{0,0,1,0,1,0,0},{0,1,1,0,1,1,0},{0,0,0,0,1,0,0},{0,1,1,1,1,1,0},{0,1,0,0,0,0,0}};
		int[] start2 = {0,1};
		int[] end2 = {6,1};
		
		System.out.println(test.mazeSolution(maze2, start2,end2));
		
		
	}
}
