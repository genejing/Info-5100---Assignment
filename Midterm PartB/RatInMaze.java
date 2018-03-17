
import java.util.ArrayList;

public class RatInMaze {
	
	class Cell{
		int x,y;
		Cell(int x,int y){
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "[" + this.x + "," + this.y + "]";
		}
	}
	
	public ArrayList<Cell> findPath(int[][] maze){
		ArrayList<Cell> res = new ArrayList<>();
		findPathHelper(maze,0,0,res);
		return res;
	}
	
	public boolean findPathHelper(int[][] maze , int row,int col,ArrayList<Cell> res) {
		int n = maze.length;
		if (row == n-1 && col == n-1 && maze[row][col] == 1) {
			Cell cell = new Cell(row, col);
			res.add(cell);
			return true;
		}
		if (row >=n || col >= n || maze[row][col] == 0) {
			return false;
		}
		
		res.add(new Cell(row, col));
		
		boolean right = findPathHelper(maze, row, col+1,res);
		if (right) return true;
		
		boolean down = findPathHelper(maze, row+1, col,res);
		if (down) return true;
		
		res.remove(res.size()-1);
		return false;
	
	}
	
	public static void main(String[] args) {
		RatInMaze rim = new RatInMaze();
		int[][] maze = {{1,0,0,0},{1,1,1,1},{0,1,0,0},{1,1,1,1}};
		System.out.println(rim.findPath(maze));
	}
}
