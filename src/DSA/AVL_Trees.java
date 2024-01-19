package DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;

public class AVL_Trees {
    static class Node {
        int key, height;
        Node left;
        Node right;
        Node (int d) {
            key = d;
            height = -1;
        }
    }

    Node root;
    int height(Node N){
        if (N==null)
            return -1;
        return N.height;
    }

    Node insert(Node node, int key){
        if(node==null) {
            return (new Node(key));
        }
        else if (key<node.key) {
            node.left = insert(node.left, key);
        }
        else if (key>node.key) {
            node.right = insert(node.right, key);
        }
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = Balance(node);

        if(balance > 1 && key < node.left.key){

            return rotate_right(node);
        }
        if (balance < -1 && key > node.right.key)
            return rotate_left(node);


        if (balance > 1 && key > node.left.key) {
            node.left = rotate_left(node.left);
            return rotate_right(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotate_right(node.right);
            return rotate_left(node);
        }

        return node;
    }

    int Balance(Node N){
        if(N==null)
            return 0;
        else
            return (height(N.left)-height(N.right));
    }

    Node rotate_right(Node N){

        Node x= N.left;
        Node z = x.right;
        x.right=N;
        N.left=z;
        N.height = max(height(N.left), height(N.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;

    }
    Node rotate_left (Node N){

        Node x= N.right;
        Node z = x.left;
        x.left=N;
        N.right=z;

        N.height = max(height(N.left), height(N.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;

    }
    static void preorder(Node root){

        if(root==null)
            return;
        System.out.print(root.key+" ");
        preorder(root.left);
        preorder(root.right);
    }

    Node getLeft(Node N,int key){
        if(N.key==key){
            return N.left;
        }
        if(root==null)
            return null;
        preorder(N.left);
        preorder(N.right);


        return null;
    }

    Node getRight(Node N,int key){
        if(N.key==key){
            return N.right;
        }
        getRight(N.left,key);
        getRight(N.right,key);

        return null;
    }

    Node getRoot(){
        return root;
    }
    public boolean contains(int x, Node N,boolean b){
        if(N==null) {
            return false;
        }
        if(N.key==x){
            return true;
        }
        b=contains(x,N.left,b);
        if(b) {
            return true;
        }
        b=contains(x,N.right,b);
        return b;

    }

    void delete(Node root, int key){
        Queue<Node> qobj= new LinkedList<>();
        Stack<Node> stk = new Stack<>();
        qobj.add(root);
        while (!qobj.isEmpty()){
            root=qobj.remove();
            if(root.key==key){
                break;
            }
            else {
                if (root.left!=null) {
                    qobj.add(root.left);
                }
                if (root.right!=null) {
                    qobj.add(root.right);
                }
            }
        }
        while (root.right!=null) {
            root.key = root.right.key;
            stk.push(root);
            root=root.right;
        }
        root=stk.pop();
        root.right=null;

    }

    boolean isAVL(Node root){
        if(root==null)
            return true;
        if(height(root.left)-height(root.right)>1 || height(root.left)-height(root.right)<-1)
            return false;

        boolean a=isAVL(root.left);
        boolean b=isAVL(root.right);
        return a && b;
    }

    public AVL_Trees(int [] a){
        int size=6;
        System.out.println("size:"+size);
        for(int i=0; i<size;i++){
            int key=a[i];
            root=insert(root,key);
        }
    }

    public AVL_Trees(){

    }

    public static void main(String[] args) {
        AVL_Trees obj = new AVL_Trees();
        boolean b = false;
        obj.root = obj.insert(obj.root, 50);
        obj.root = obj.insert(obj.root, 60);
        obj.root = obj.insert(obj.root, 70);
        obj.root = obj.insert(obj.root, 80);
        obj.root = obj.insert(obj.root, 90);

        preorder(obj.root);
        System.out.println();

//
        int[] arr= new int[10];
        arr[0]=30;
        arr[1]=10;
        arr[2]=20;
        arr[3]=40;
        arr[4]=50;
        arr[5]=25;
        AVL_Trees obj2=new AVL_Trees(arr);
        preorder(obj2.root);
        System.out.println();
//

//        System.out.println("Is avl: " + obj.isAVL(obj.root));
//        System.out.println("Left node: " + obj.getLeft(obj.root, 30).key);
//        System.out.println("Right node: " + obj.getRight(obj.root, 30).key);
//        System.out.println("Root: " + obj.getRoot().key);
//        System.out.println("40 Exists: " + obj.contains(40, obj.root, b));
//        obj.delete(obj.root, 40);
//        preorder(obj.root);
    }
}
