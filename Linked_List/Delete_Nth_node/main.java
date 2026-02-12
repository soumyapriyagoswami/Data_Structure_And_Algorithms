public class main{

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast to n+1 steps ahead
        for(int i = 0; i <= n; i++){
            fast = fast.next;
             System.out.println("Step " + (i+1) + ": Fast moved to: " + (fast != null ? fast.val : "null"));
        }

        // move both pointers untill both pointers reach end
        System.out.println("\nMoving both pointers until fast reaches end:");
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            System.out.println("Slow at: " + slow.val + ", Fast at: " + (fast != null ? fast.val : "null"));
        }

        // Remove nth node from end
        System.out.println("\nRemoving node with value: " + slow.next.val);
        slow.next = slow.next.next;

        return dummy.next;

    }

     // Helper method to create linked list
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
        // Test Case: Remove 2nd node from end
        // List: 1 -> 2 -> 3 -> 4 -> 5, n = 2
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(arr);
        
        System.out.println("Original Linked List:");
        printLinkedList(head);
        System.out.println("\nRemoving 2nd node from end (value 4)...\n");
        
        ListNode result = removeNthFromEnd(head, 2);
        
        System.out.println("\nLinked List after removal:");
        printLinkedList(result);
    }
}