import java.util.*;

public class maxOccuringChar{
    public static char maxFreq(String str){

        /* freq array of 256 size for storing each character frequency
         * Need an for loop to traverse the string and store each character in the freq array
         * for calculating frequency
         * Now find the character with maximum frequency from the string by comparing
         */

        if(str == null || str.isEmpty())throw new IllegalArgumentException("String cannot be empty or null");
        int[] freq = new int[256]; // An array for storing ASCII character
        for(char c: str.toCharArray()) freq[c]++; // Count the frequency of each character

        // Find character with maximum frequency
        char maxChar = str.charAt(0); 
        int maxCount = 0; 
        for(int i = 0; i < 256; i++){
            if(freq[i] > maxCount){
                maxCount = freq[i];
                maxChar = (char)i;
            }
        }  
        return maxChar;
    }
    
    public static void main(String[] args) {
        // Test cases to check
        String str1 = "takeuforward";
        String str2 = "apple";
        String str3 = "aabbcc";
        String str4 = "hello world";
        String str5 = "\0";

        System.out.println("Output is given below:");
        // Fixed: Changed maxOccuringChar to maxFreq
        System.out.println("Input: " + str1 + " -> Output: " + maxFreq(str1));
        System.out.println("Input: " + str2 + " -> Output: " + maxFreq(str2));
        System.out.println("Input: " + str3 + " -> Output: " + maxFreq(str3));
        System.out.println("Input: " + str4 + " -> Output: " + maxFreq(str4));
        System.out.println("Input: " + str5 + " -> Output: " + maxFreq(str5));
    }
}