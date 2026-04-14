import java.util.*;
public class main{
    static class Solution{
        // function to find maximum k elements sum
        public List<Integer> maxCombination(int[] num1, int[] num2 , int k){
            // sort both arrays
            Arrays.sort(num1);
            Arrays.sort(num2);
            int n = num1.length;

            // max heap to store the sums and indices
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[0]-a[0]);

            // set to keep track the visited array
            Set<String> visited = new HashSet<>();

            // push initial sum to the queue
            maxHeap.offer(new int[]{num1[n-1]+num2[n-1],n-1,n-1});
            visited.add((n-1)+","+(n-1));

            List<Integer> result = new ArrayList<>();

            // extract top k combinations
            while(k-- > 0 && !maxHeap.isEmpty()){
                int[] current = maxHeap.poll();
                int sum = current[0], i = current[1], j = current[2];

                result.add(sum);

                // check new combinations i-1, j
                if(i-1>=0){
                    String key1 = (i-1)+","+j;
                    if(!visited.contains(key1)){
                        maxHeap.offer(new int[]{num1[i-1]+num2[j], i-1,j});
                        visited.add(key1);
                    }
                }

                // check new combination i,j-1
                if(j-1>=0){
                    String key2 = i+","+(j-1);
                    if(!visited.contains(key2)){
                        maxHeap.offer(new int[]{num1[i]+num2[j-1], i,j-1});
                        visited.add(key2);
                    }
                }

            }
            return result;

        }
    }
    public static void main(String[] args) {
        Solution object = new Solution();

        int[] nums1 = {7, 3,5};
        int[] nums2 = {1, 6,99};
        int k = 2;
        System.out.println(object.maxCombination(nums1, nums2, k));
    }
}