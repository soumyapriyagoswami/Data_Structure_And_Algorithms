import java.util.*;
class Detect_Cycle{

    // Kahn's algorithm approach using BFS
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adjList){
        int indegree[] = new int[N];
        for(int i = 0; i < N; i++){
            for(Integer it:adjList.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            count++;
            for(Integer it: adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) queue.add(it);
            }
        }
        if(count == N) return false;
        return true;
    }

}

class Solution{
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(2);

        Detect_Cycle obj = new Detect_Cycle();
        boolean ans = obj.isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}