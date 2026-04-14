public class main {

    static class Node {  // Make Node static
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class Solution {
        public static void findPreSuc(Node root, int key) {
            Node pre = null;
            Node suc = null;
            Node current = root;
            
            while (current != null && current.data != key) {
                if (key < current.data) {
                    suc = current;
                    current = current.left;
                } else {
                    pre = current;
                    current = current.right;
                }
            }

            // if key node was found
            if (current != null) {
                // find predecessor: max in left subtree
                if (current.left != null) {
                    Node temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre = temp;
                }
                // find successor: min in right subtree
                if (current.right != null) {
                    Node temp = current.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc = temp;
                }
            }
            
            System.out.println("Predecessor: " + (pre != null ? pre.data : "null"));
            System.out.println("Successor: " + (suc != null ? suc.data : "null"));
        }

        public static void findPreSucUsingTraversal(Node root, int key) {
            Node pre = null;
            Node suc = null;
            Node current = root;
            
            while (current != null) {
                if (key < current.data) {
                    suc = current;
                    current = current.left;
                } else if (key > current.data) {
                    pre = current;
                    current = current.right;
                } else {
                    // Found the key node
                    
                    // Find predecessor: maximum in left subtree
                    if (current.left != null) {
                        Node temp = current.left;
                        while (temp.right != null) {
                            temp = temp.right;
                        }
                        pre = temp;
                    }
                    
                    // Find successor: minimum in right subtree
                    if (current.right != null) {
                        Node temp = current.right;
                        while (temp.left != null) {  // Fixed: was temp.right before
                            temp = temp.left;
                        }
                        suc = temp;
                    }
                    break;
                }
            }
            
            System.out.println("Using traversal method:");
            System.out.println("Predecessor: " + (pre != null ? pre.data : "null"));
            System.out.println("Successor: " + (suc != null ? suc.data : "null"));
        }

        public static Node insert(Node root, int data) {
            if (root == null) {  // Fixed: was root != null
                return new Node(data);
            }

            if (data < root.data) {
                root.left = insert(root.left, data);
            } else if (data > root.data) {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        // Create a sample BST
        Node root = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        
        for (int value : values) {
            root = Solution.insert(root, value);  // Added Solution. prefix
        }
        
        // Test cases
        System.out.println("For key = 40:");
        Solution.findPreSuc(root, 40);  // Added Solution. prefix
        Solution.findPreSucUsingTraversal(root, 40);  // Added Solution. prefix
        System.out.println();
        
        System.out.println("For key = 50:");
        Solution.findPreSuc(root, 50);
        Solution.findPreSucUsingTraversal(root, 50);
        System.out.println();
        
        System.out.println("For key = 20 (first element):");
        Solution.findPreSuc(root, 20);
        Solution.findPreSucUsingTraversal(root, 20);
        System.out.println();
        
        System.out.println("For key = 80 (last element):");
        Solution.findPreSuc(root, 80);
        Solution.findPreSucUsingTraversal(root, 80);
    }
}