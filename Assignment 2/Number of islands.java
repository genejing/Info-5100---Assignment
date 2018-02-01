class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i =0; i < row; i++) {
            for (int j=0;j < col; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    ans++;
                }
            }
        
        }
        return ans;
    }
    
    public void DFS(char[][] grid, int x, int y) {
        if ( x<0 || y<0 || x > grid.length-1 || y > grid[0].length-1 || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        DFS(grid,x-1,y);
        DFS(grid,x+1,y);
        DFS(grid,x,y-1);
        DFS(grid,x,y+1);
    }
}
