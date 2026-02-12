import java.util.*;
class number_of_island{
    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vec, int row0, int col0){
        // mark all the cell as visited
        vis[row][col] = 1;

        // coordinates - base coordinates
        vec.add(toString(row-row0, col-col0));
        int n = grid.length;
        int m = grid[0].length;

        // delta row and columns
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, -1, 0, 1};


        // traverse all 4 neighbors
        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];


            // check for valid coordinates
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, grid, vec, row0, col0);
            }
        }
    }

    private String toString(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    int countDistinctElement(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        HashSet<ArrayList<String>> st = new HashSet<>();
        
        // if not visited and a land cell
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    // store in hash set
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
}
class Pair{
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class solution{
    public static void main(String[] args) {
        int grid[][] = {
        {1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1}};

    number_of_island ob = new number_of_island();
    int ans = ob.countDistinctElement(grid);
    System.out.println(ans);
    }
}