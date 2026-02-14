public class main{
    public static int trap(int[] height){
        // Edge cases
        if(height == null || height.length < 3) return 0;

        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;


        System.out.println("Starting Two-Pointer Traversal:");
        System.out.println("Index | Height | maxLeft | maxRight | Water Added | Total");
        System.out.println("-".repeat(60));

        while(left <= right){
            if(height[left] <= height[right]){
                int waterAdded = 0;
                if(height[left] > maxLeft){
                    maxLeft = height[left];
                    System.out.printf("%5d | %6d | %7d | %8d | %11d | %5d%n", 
                        left, height[left], maxLeft, maxRight, waterAdded, totalWater);
                }
                else{
                    waterAdded = maxLeft-height[left];
                    totalWater += waterAdded;
                    System.out.printf("%5d | %6d | %7d | %8d | %11d | %5d%n", 
                        left, height[left], maxLeft, maxRight, waterAdded, totalWater);
                }
                left++;
                }
                else{
                    // process right side
                    int waterAdded = 0;
                    if(height[right]>maxRight){
                        maxRight = height[right];
                        System.out.printf("%5d | %6d | %7d | %8d | %11d | %5d%n", 
                        right, height[right], maxLeft, maxRight, waterAdded, totalWater);
                    }else{
                        waterAdded = maxRight - height[right];
                        totalWater += waterAdded;
                        System.out.printf("%5d | %6d | %7d | %8d | %11d | %5d%n", 
                        right, height[right], maxLeft, maxRight, waterAdded, totalWater);
                    }
                    right--;
                }
            }
            return totalWater;
        }
        public static void visualizeWater(int[] height, int totalWater){
             System.out.println("\n" + "=".repeat(50));
             System.out.println("Visual Representation:");

             int maxHeight = 0;
             for(int h: height){
                maxHeight = Math.max(maxHeight,h);
             }
              for(int level = maxHeight; level > 0; level--) {
            System.out.printf("%2d | ", level);
            for (int h : height) {
                if (h >= level) {
                    System.out.print("■ "); // Solid block
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 0; i < height.length; i++) {
            System.out.print("--");
        }
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < height.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n\nHeights: " + java.util.Arrays.toString(height));
        System.out.println("Total Trapped Water: " + totalWater + " units");
        }
        public static void main(String[] args){
            // Test Case 1: Classic example
            System.out.println("Test Case 1: [0,1,0,2,1,0,1,3,2,1,2,1]");
            int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            int result1 = trap(height1);
            visualizeWater(height1, result1);
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Test Case 2: Simple case
            System.out.println("Test Case 2: [4,2,0,3,2,5]");
            int[] height2 = {4, 2, 0, 3, 2, 5};
            int result2 = trap(height2);
            visualizeWater(height2, result2);
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Test Case 3: No water can be trapped
            System.out.println("Test Case 3: [1,2,3,4,5] (Increasing)");
            int[] height3 = {1, 2, 3, 4, 5};
            int result3 = trap(height3);
            visualizeWater(height3, result3);
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Test Case 4: Decreasing heights
            System.out.println("Test Case 4: [5,4,3,2,1] (Decreasing)");
            int[] height4 = {5, 4, 3, 2, 1};
            int result4 = trap(height4);
            visualizeWater(height4, result4);
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Test Case 5: Plateau
            System.out.println("Test Case 5: [3,3,3,3,3] (Plateau)");
            int[] height5 = {3, 3, 3, 3, 3};
            int result5 = trap(height5);
            visualizeWater(height5, result5);
    }
    }

    
