public class main{
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        // creating a dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse the lists untill one becomes null
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // attach the remaining nodes 
        if(list1 != null){
            current.next = list1;
        }

        if(list2 != null){
            current.next = list2;
        }
        return dummy.next;
    }

     // Helper method to create a linked list from array
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }

    // Helper method to print linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Test Case 1: Both lists have multiple elements
        System.out.println("Test Case 1: Merging two sorted lists");
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        
        ListNode list1 = createLinkedList(arr1);
        ListNode list2 = createLinkedList(arr2);
        
        System.out.print("List 1: ");
        printLinkedList(list1);
        System.out.print("List 2: ");
        printLinkedList(list2);
        
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        printLinkedList(merged);
        System.out.println();
        
        // Test Case 2: One list is empty
        System.out.println("Test Case 2: One empty list");
        int[] arr3 = {1, 2, 3};
        ListNode list3 = createLinkedList(arr3);
        ListNode list4 = null;
        
        System.out.print("List 3: ");
        printLinkedList(list3);
        System.out.println("List 4: null");
        
        ListNode merged2 = mergeTwoLists(list3, list4);
        System.out.print("Merged List: ");
        printLinkedList(merged2);
        System.out.println();
        
        // Test Case 3: Lists with duplicate values
        System.out.println("Test Case 3: Lists with duplicates");
        int[] arr5 = {1, 2, 4};
        int[] arr6 = {1, 3, 4};
        
        ListNode list5 = createLinkedList(arr5);
        ListNode list6 = createLinkedList(arr6);
        
        System.out.print("List 5: ");
        printLinkedList(list5);
        System.out.print("List 6: ");
        printLinkedList(list6);
        
        ListNode merged3 = mergeTwoLists(list5, list6);
        System.out.print("Merged List: ");
        printLinkedList(merged3);
        System.out.println();
        
        // Test Case 4: Lists of different lengths
        System.out.println("Test Case 4: Different lengths");
        int[] arr7 = {1, 5};
        int[] arr8 = {2, 3, 4, 6, 7};
        
        ListNode list7 = createLinkedList(arr7);
        ListNode list8 = createLinkedList(arr8);
        
        System.out.print("List 7: ");
        printLinkedList(list7);
        System.out.print("List 8: ");
        printLinkedList(list8);
        
        ListNode merged4 = mergeTwoLists(list7, list8);
        System.out.print("Merged List: ");
        printLinkedList(merged4);
    }
}