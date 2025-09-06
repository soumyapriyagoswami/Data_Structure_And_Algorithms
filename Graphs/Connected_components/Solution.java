import java.util.*;

class Solution {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : adj.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static int number_of_connected_components_dfs(int V, int E, int[][] edges) {
        // create an adjacency list
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        // Add edges to adjacency list (undirected graph)
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adjLs, visited);
            }
        }
        return count;
    }

    public static int number_of_connected_components_bfs(int V, int E, int[][] edges) {
        // create an adjacency list
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        // Add edges to adjacency list (undirected graph)
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                count++;
                bfs(i, adjLs, visited);
            }
        }
        return count;
    }
}

class Solution_main {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 3; // Number of edges
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        System.out.println(Solution.number_of_connected_components_dfs(V, E, edges)); // Output: 2
        System.out.println(Solution.number_of_connected_components_bfs(V, E, edges)); // Output: 2
    }
}