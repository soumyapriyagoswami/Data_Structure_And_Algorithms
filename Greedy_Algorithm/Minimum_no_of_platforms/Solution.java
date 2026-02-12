import java.util.*;
class Platform{
    static int max_platform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int number_of_platform = 1, result = 1;
        int i = 1,j = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                number_of_platform++;
                i++;
            }
            else if(arr[i] > dep[j]){
                number_of_platform--;
                j++;
            }
            if(number_of_platform > result){
                result = number_of_platform;
            }
        }
        return result;
    }
}
class Solution{
    public static void main(String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length;
		int totalCount=Platform.max_platform(arr,dep,n);
		System.out.println("Minimum number of Platforms required "+totalCount);
    }
}