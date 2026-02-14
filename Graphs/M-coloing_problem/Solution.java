public class Solution{
    private static boolean isSafe(int vertex, int[][] graph, int[] color, int currentColor, int n){
        for(int i = 0; i < n; i++){
            if(graph[vertex][i] == 1 && color[i] == currentColor) return false;
        }
        return true;
    }

    // recursive backtracking
    private static boolean solve(int vertex, int[][] graph, int[] color, int m, int n){

        // Base case: all vertices are colored
        if(vertex == n) return true;
        for(int c = 1; c <= m; c++){
            if(isSafe(vertex, graph, color,c,n)){
                color[vertex] = c;
                printCurrentState(vertex, color, n);
                if(solve(vertex+1, graph, color, m,n)) return true;
                color[vertex] = 0;
                System.out.println("Backtracking from vertex " + vertex + " with color " + c);
            }
        }
        return false;
    }

   // Helper function to print current coloring state
    private static void printCurrentState(int vertex, int[] color, int n) {
        System.out.print("After coloring vertex " + vertex + ": [");
        for (int i = 0; i < n; i++) {
            if (i <= vertex) {
                System.out.print(color[i]);
            } else {
                System.out.print("_");
            }
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    // Function to print graph in adjacency matrix format
    private static void printGraph(int[][] graph, int n) {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Main function to solve m-coloring problem
    public static boolean graphColoring(int[][] graph, int m, int n) {
        int[] color = new int[n];
        System.out.println("\nStarting to color graph with " + m + " colors...");
        System.out.println("Colors available: " + m + " (represented as 1 to " + m + ")");
        System.out.println("0 means uncolored\n");
        
        boolean result = solve(0, graph, color, m, n);
        
        if (result) {
            System.out.println("\n✓ Success! Graph colored with " + m + " colors:");
            for (int i = 0; i < n; i++) {
                System.out.println("  Vertex " + i + " → Color " + color[i]);
            }
        } else {
            System.out.println("\n✗ Cannot color graph with " + m + " colors");
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        
        // Test Case 1: Graph that can be colored with 3 colors (e.g., a pentagon)
        System.out.println("=".repeat(70));
        System.out.println("TEST CASE 1: Pentagon Graph (5 vertices in a cycle)");
        System.out.println("=".repeat(70));
        
        int n1 = 5;
        int[][] graph1 = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
        
        printGraph(graph1, n1);
        graphColoring(graph1, 3, n1);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("TEST CASE 2: Complete Graph K4 (needs 4 colors)");
        System.out.println("=".repeat(70));
        
        // Test Case 2: Complete graph K4 (needs 4 colors)
        int n2 = 4;
        int[][] graph2 = {
            {0, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 0}
        };
        
        printGraph(graph2, n2);
        System.out.println("Trying with 3 colors (should fail):");
        graphColoring(graph2, 3, n2);
        
        System.out.println("\nTrying with 4 colors (should succeed):");
        graphColoring(graph2, 4, n2);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("TEST CASE 3: Bipartite Graph (can be colored with 2 colors)");
        System.out.println("=".repeat(70));
        
        // Test Case 3: Bipartite graph
        int n3 = 4;
        int[][] graph3 = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        
        printGraph(graph3, n3);
        graphColoring(graph3, 2, n3);
    }
}
