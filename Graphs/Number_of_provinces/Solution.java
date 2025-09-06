
import java.util.*;

class Solution {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for(Integer it : adj.get(node)) {
            if(visited[it] == 0) { 
                dfs(it, adj, visited);
            }
        }
    }

    public static int Number_of_provinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        
        // Initialize adjacency list with empty ArrayLists
        for(int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<Integer>()); // Fixed: removed null parameter
        }

        // Convert adjacency matrix to adjacency list
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                // self nodes are not considered
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int count = 0;

        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                count++;
                dfs(i, adjLs, vis);
            }
        }
        return count;
    }
}

class Solution_main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        // Create a 3x3 adjacency matrix
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));

        System.out.println(Solution.Number_of_provinces(adj, 3));
    }
}