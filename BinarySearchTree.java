class BST_class { 
   
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    
    Node root; 
  
   // Constructor for BST =>initial empty tree
    BST_class(){ 
        root = null; 
    } 
   
    void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   
    
    Node delete_Recursive(Node root, int key)  { 
       
        if (root == null)  return root; 
   
       
        if (key < root.key)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key); 
        else  { 
           
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
           
            
            root.key = minValue(root.right); 
   
         
            root.right = delete_Recursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(Node root)  { 
       
        int minval = root.key; 
       
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
   
    void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
   
   
    Node insert_Recursive(Node root, int key) { 
         
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
     
        if (key < root.key)    
            root.left = insert_Recursive(root.left, key); 
        else if (key > root.key)    
            root.right = insert_Recursive(root.right, key); 
        
        return root; 
    } 
 

    void inorder() { 
        inorder_Recursive(root); 
    } 
   
   
    void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
     
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
   
    Node search_Recursive(Node root, int key)  { 
       
        if (root==null || root.key==key) 
            return root; 
        
        if (root.key > key) 
            return search_Recursive(root.left, key); 
       
        return search_Recursive(root.right, key); 
    } 
}
class Main{
    public static void main(String[] args)  { 
     
        BST_class bst = new BST_class(); 
       
        bst.insert(45); 
        bst.insert(10); 
        bst.insert(7); 
        bst.insert(12); 
        bst.insert(90); 
        bst.insert(50); 
      
        System.out.println("The BST Created with input data(Left-root-right):"); 
        bst.inorder(); 
        
        
        System.out.println("\nThe BST after Delete 12(leaf node):"); 
        bst.deleteKey(12); 
        bst.inorder(); 
       
        System.out.println("\nThe BST after Delete 90 (node with 1 child):"); 
        bst.deleteKey(90); 
        bst.inorder(); 
                 

        System.out.println("\nThe BST after Delete 45 (Node with two children):"); 
        bst.deleteKey(45); 
        bst.inorder(); 
        
        boolean ret_val = bst.search (50);
        System.out.println("\nKey 50 found in BST:" + ret_val );
        ret_val = bst.search (12);
        System.out.println("\nKey 12 found in BST:" + ret_val );
     } 
}