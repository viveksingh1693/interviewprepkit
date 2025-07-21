package graph;

public class NumberofIslands {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i=0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        // 1. Base case: boundaries and conditions

        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == '0'
        ) {
            return;
        }


        // 2. Mark as visited
        grid[row][col] = '0';
        // 3. Explore 4 directions recursively
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

        // 4. Backtrack if needed
    }

}
