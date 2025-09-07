import java.util.*;

class solution {
    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int delRow[], int delCol[],
            int iniColor) {

        // color with new color
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        // there are exactly 4 neighbours
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            // check valid co ordinate then check same initial colour and unvisited pixel
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == iniColor
                    && ans[nRow][nCol] != newColor) {
                dfs(nRow, nCol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }

    public  int[][] flood_fill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = image;

        // delta row and columns for neighbours
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, 0, -1 };

        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }
}

class solution_main {
    public static void main(String[] args) {
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
    };
    solution sol1 = new solution();

    int[][] ans = sol1.flood_fill(image,1, 1, 2);
    for(int i = 0; i < ans.length; i++){
        for(int j = 0; j < ans[i].length; j++){
            System.out.print(ans[i][j]+" ");
        }
        System.out.println();
    }
}
}