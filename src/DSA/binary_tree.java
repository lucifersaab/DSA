package DSA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class binary_tree {

     static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }
    static Node root;

      Node creation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data:");
        int x=sc.nextInt();
        if(x==-1) {
            return null;
        }
        root= new Node(x);
        System.out.println("Enter left child of root "+root.data);
        root.left=creation();
        System.out.println("Enter right child of root "+root.data);
        root.right=creation();
        return root;
     }
     Node leftnode(Node node){
         node=node.left;
         return node;
     }

    Node rightnode(Node node){
        node=node.right;
        return node;
    }
    boolean hasleft(Node node){
         return node.left!= null;
    }
    boolean hasright(Node node){return node.right!=null; }

     static void inorder(Node root){

             if (root == null)
                 return;
             Stack<Node> s = new Stack<>();
             Node curr = root;
             while (curr != null || s.size() > 0)
             {
                 while (curr !=  null)
                 {
                     s.push(curr);
                     curr = curr.left;
                 }
                 curr = s.pop();
                 System.out.print(curr.data + " ");
                 curr = curr.right;
             }

//        if(root==null)
//            return;
//        inorder(root.left);
//        System.out.print(root.data+" ");
//        inorder(root.right);
     }
     int count=0;

     static void preorder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root){
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }

}
