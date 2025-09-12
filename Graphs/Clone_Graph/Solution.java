import java.util.*;

// Node class definition
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// Solution class with BFS approach
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        // Map to store original node -> cloned node mapping
        Map<Node, Node> visited = new HashMap<>();
        
        // Create a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        
        // Create the first node (clone of the given node)
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node clonedCurrent = visited.get(current);
            
            // Process all neighbors of the current node
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // If neighbor hasn't been visited, create a clone and add to queue
                    Node clonedNeighbor = new Node(neighbor.val);
                    visited.put(neighbor, clonedNeighbor);
                    queue.offer(neighbor);
                }
                // Add the cloned neighbor to the cloned current node's neighbors list
                clonedCurrent.neighbors.add(visited.get(neighbor));
            }
        }
        
        return cloneNode;
    }
}

// Main class with test cases
class CloneGraph {
    
    // Helper method to create a graph from adjacency list
    public static Node createGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) return null;
        
        Map<Integer, Node> nodes = new HashMap<>();
        
        // Create all nodes first
        for (int i = 1; i <= adjList.length; i++) {
            nodes.put(i, new Node(i));
        }
        
        // Connect neighbors
        for (int i = 0; i < adjList.length; i++) {
            Node currentNode = nodes.get(i + 1);
            for (int neighborVal : adjList[i]) {
                currentNode.neighbors.add(nodes.get(neighborVal));
            }
        }
        
        return nodes.get(1);
    }
    
    // Helper method to convert graph to adjacency list (for verification)
    public static List<List<Integer>> graphToAdjList(Node node) {
        if (node == null) return new ArrayList<>();
        
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(node);
        visited.add(node.val);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            List<Integer> neighborsList = new ArrayList<>();
            
            for (Node neighbor : current.neighbors) {
                neighborsList.add(neighbor.val);
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.offer(neighbor);
                }
            }
            
            adjMap.put(current.val, neighborsList);
        }
        
        // Convert to list of lists (index 0 = node 1, index 1 = node 2, etc.)
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= adjMap.size(); i++) {
            result.add(adjMap.get(i));
        }
        
        return result;
    }
    
    // Helper method to print adjacency list
    public static void printAdjList(List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Node " + (i + 1) + ": ");
            System.out.println(adjList.get(i));
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Simple graph with 2 nodes
        System.out.println("Test Case 1: Graph with 2 nodes");
        int[][] adjList1 = {{2}, {1}};
        Node graph1 = createGraph(adjList1);
        Node clonedGraph1 = solution.cloneGraph(graph1);
        List<List<Integer>> result1 = graphToAdjList(clonedGraph1);
        printAdjList(result1);
        System.out.println();
        
        // Test case 2: Graph with 4 nodes in a square
        System.out.println("Test Case 2: Graph with 4 nodes");
        int[][] adjList2 = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node graph2 = createGraph(adjList2);
        Node clonedGraph2 = solution.cloneGraph(graph2);
        List<List<Integer>> result2 = graphToAdjList(clonedGraph2);
        printAdjList(result2);
        System.out.println();
        
        // Test case 3: Single node
        System.out.println("Test Case 3: Single node");
        int[][] adjList3 = {{}};
        Node graph3 = createGraph(adjList3);
        Node clonedGraph3 = solution.cloneGraph(graph3);
        List<List<Integer>> result3 = graphToAdjList(clonedGraph3);
        printAdjList(result3);
        System.out.println();
        
        // Test case 4: Empty graph
        System.out.println("Test Case 4: Empty graph");
        Node graph4 = null;
        Node clonedGraph4 = solution.cloneGraph(graph4);
        if (clonedGraph4 == null) {
            System.out.println("Empty graph handled correctly");
        }
        System.out.println();
        
        // Test case 5: Complex graph
        System.out.println("Test Case 5: Complex graph");
        int[][] adjList5 = {{2, 3}, {1, 4}, {1, 4}, {2, 3, 5}, {4}};
        Node graph5 = createGraph(adjList5);
        Node clonedGraph5 = solution.cloneGraph(graph5);
        List<List<Integer>> result5 = graphToAdjList(clonedGraph5);
        printAdjList(result5);
    }
}