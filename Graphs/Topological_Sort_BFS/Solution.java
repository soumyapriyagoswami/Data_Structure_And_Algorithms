import java.util.*;
import java.lang.*;
import java.io.*;
class Topological_sort{
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj){
        int topo[] = new int[N];
        int indegree[] = new int[N];

        // finding indegree
        for(int i = 0; i < N; i++){
            for(Integer it: adj.get(i)) indegree[it]++;
        }

        // adding nodes with indegree with 0 in the queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) if(indegree[i] == 0) queue.add(i);
        int count = 0, index = 0;
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            topo[index++] = node;
            count++;

            // getting neighbors of the popped nodes and decrease indegree by 1
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) queue.add(it);

            }
        }
        // printing topological order nodes
        for (int i=0;i< topo.length;i++){
            System.out.print(topo[i]+" ");
        }
        if(count == N) return false;
        return true;

    }

}

class Solution{
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

            // adding new arraylists to 'adj' to add neighbour nodes
            for (int i = 0; i < 6; i++) {
                adj.add(new ArrayList < > ());
            }


            adj.get(5).add(2);
            adj.get(5).add(0);
            adj.get(4).add(0);
            adj.get(4).add(1);
            adj.get(3).add(1);
            adj.get(2).add(3);


           new Topological_sort().isCyclic(6,adj);
    }
}