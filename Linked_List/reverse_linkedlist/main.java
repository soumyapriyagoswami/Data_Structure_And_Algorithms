public class main{
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static ListNode CreateLinkedList(int[] arr){
        if(arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for(int i = 1; i < arr.length; i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;

    }

    public static void printList(ListNode head){
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
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = CreateLinkedList(arr);
        
        System.out.println("Original linked list:");
        printList(head);
        
        // Reverse the linked list
        ListNode reversedHead = reverseList(head);
        
        System.out.println("Reversed linked list:");
        printList(reversedHead);
    }


}