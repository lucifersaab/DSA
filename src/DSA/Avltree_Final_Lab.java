package DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;

public class Avltree_Final_Lab {

    static class Node{
        int data;
        Node left,right;
        int height;

        Node(int data){
            this.data=data;
            height=0;
        }

    }

    Node root=null;

    Node insert(Node node, int key){
        if(node==null) {
            return (new Node(key));
        }
        else if (key<node.data) {
            node.left = insert(node.left, key);
        }
        else if (key>node.data) {
            node.right = insert(node.right, key);
        }
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = balance(node);

        if(balance > 1 && key < node.left.data){

            return rotate_right(node);
        }
        if (balance < -1 && key > node.right.data)
            return rotate_left(node);


        if (balance > 1 && key > node.left.data) {
            node.left = rotate_left(node.left);
            return rotate_right(node);
        }

        if (balance < -1 && key < node.right.data) {
            node.right = rotate_right(node.right);
            return rotate_left(node);
        }

        return node;
    }

    Node rotate_right(Node N){

       Node x= N.left;
        Node temp = x.right;
        x.right=N;
        N.left=temp;
        N.height = max(height(N.left), height(N.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }


    Node rotate_left(Node N){


        Node x= N.right;
        Node temp = x.left;
        x.left=N;
        N.right=temp;

        N.height = max(height(N.left), height(N.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    int balance(Node node){

        if(node==null)
            return 0;
        else return height(node.left)-height(node.right);
    }

    int height(Node node){

        if(node==null)
            return -1;
        else
            return node.height;
    }

    void preorder(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    Node search(Node root, int key){
        Queue<Node> qobj= new LinkedList<>();
        qobj.add(root);
        while (!qobj.isEmpty()){
            root=qobj.remove();
            if(root.data==key){
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
        if(root.data!=key)
            return null;

        return root;
    }

    void printRight(int key){

        Node N=search(root, key);
        Node temp;
        if(N.right!=null) {
             temp=N.right;
             int[] arr = new int[10];
             int index=0;
            Queue<Node> q= new LinkedList<>();
            q.add(temp);

            while (!q.isEmpty()) {
                temp= q.remove();
                arr[index]=temp.data;

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                index++;
            }

            int min;
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index-1; j++) {
                    if(arr[j]>arr[j+1]){
                        min=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=min;
                    }
                }
            }

            for(int i=0;i<index;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
    Avltree_Final_Lab(){

    }
    public Avltree_Final_Lab(int [] a){
        int size=a.length;

        for(int i=0; i<size;i++){
            int key=a[i];
            root=insert(root,key);
        }
    }

    Node remove(Node node,int key) {
        if (node != null) {
            if (key == node.data) {
                if (node.left != null && node.right != null) {
                    Node succ = inorder_predecessor(node);
                    copy(node, succ);
                    node.right = remove(node.right, succ.data);
                } else
                    node = getChildNode(node);
            } else if (key < node.data) {
                node.left = remove(node.left, key);
            } else {
                node.right = remove(node.right, key);
            }

            int balance = balance(node);

            if (balance > 1 && key < node.left.data) {

                return rotate_right(node);
            }
            if (balance < -1 && key > node.right.data)
                return rotate_left(node);


            if (balance > 1 && key > node.left.data) {
                node.left = rotate_left(node.left);
                return rotate_right(node);
            }

            if (balance < -1 && key < node.right.data) {
                node.right = rotate_right(node.right);
                return rotate_left(node);
            }
        }
        return node;
    }
        Node getChildNode(Node node){
            if(node.left!=null){
                return node.left;
            }
            if(node.right!=null){
                return node.right;
            }
            else
                return null;
        }
        Node copy(Node node, Node succ){
            node.data=succ.data;
            return node;
        }

        Node inorder_predecessor(Node node){
            Node curr= node.left;
            while (curr.right!=null){
                curr= curr.right;
            }
            return curr;
        }

    int parent(Node root, int node){

        if (root != null) {
            Stack<Node> stk= new Stack<>();
            stk.push(root);
            while (!stk.isEmpty()) {
                System.out.println("while");
                root = stk.pop();
                if(root.right!=null){
                    if (root.right.data == node)
                        break;
                    stk.push(root.right);
                }if(root.left!=null){
                    if (root.left.data == node)
                        break;
                    stk.push(root.left);
                }
            }
        }
        if(root==null){
            System.out.println("Parent not found for:");
            return node;
        }
        else return root.data;
    }


}

