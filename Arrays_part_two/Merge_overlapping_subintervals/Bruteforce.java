import java.util.*;
public class Bruteforce {
    public static List<List<Integer>> merge_overlapping_intervals(int[][] arr){
        int n = arr.length;

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });


        List<List<Integer>> ans = new ArrayList<>();


        // select an interval
        for(int i = 0; i < n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            // skip all merge intervals
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)) continue;

            // check the rest intervals
            for(int j = i+1; j < n; j++){
                if(arr[j][0] <= end) end = Math.max(end,arr[j][1]);
                break;
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }


    public static void main(String[] args){
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = merge_overlapping_intervals(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}
