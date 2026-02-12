public class main{
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode findMiddleNode(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode createLinkedList(int[] arr){
        if(arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for(int i = 1; i < arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static void printLinkedList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val);
            if(current.next != null){
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        // Test Case 1: Odd number of nodes (5 nodes)
        System.out.println("Test Case 1: Odd length list");
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createLinkedList(arr1);
        System.out.print("Linked List: ");
        printLinkedList(head1);
        ListNode middle1 = findMiddleNode(head1);
        System.out.println("Middle node value: " + middle1.val + "\n");
        
        // Test Case 2: Even number of nodes (6 nodes)
        System.out.println("Test Case 2: Even length list");
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        ListNode head2 = createLinkedList(arr2);
        System.out.print("Linked List: ");
        printLinkedList(head2);
        ListNode middle2 = findMiddleNode(head2);
        System.out.println("Middle node value (second middle): " + middle2.val + "\n");
        
        // Test Case 3: Single node
        System.out.println("Test Case 3: Single node");
        int[] arr3 = {1};
        ListNode head3 = createLinkedList(arr3);
        System.out.print("Linked List: ");
        printLinkedList(head3);
        ListNode middle3 = findMiddleNode(head3);
        System.out.println("Middle node value: " + middle3.val + "\n");
        
        // Test Case 4: Two nodes
        System.out.println("Test Case 4: Two nodes");
        int[] arr4 = {1, 2};
        ListNode head4 = createLinkedList(arr4);
        System.out.print("Linked List: ");
        printLinkedList(head4);
        ListNode middle4 = findMiddleNode(head4);
        System.out.println("Middle node value (second middle): " + middle4.val);
    }
}