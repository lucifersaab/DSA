package DSA;

import java.util.LinkedList;
import java.util.Scanner;

public class Queue {
    static int front=-1;
    static int back=-1;
    int a[];
    static int input;
    static int size;


    public void makequeue(int n){
            a=new int[n];
    }
    public void enqueue(int b){
        if (!isfull())
        a[++back]=b;
        if(front==-1){
            front++;
        }
    }

    public int dequeue(){
        int z=0;

        if(!isempty()){
            z=a[front++];
        }
        else
        {
        System.exit(1);
        }
        return z;
    }
    public boolean isfull(){
        if(back==a.length-1){
            return true;
        }
        else return false;
    }
    public boolean isempty(){
        if(back==-1){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        int v;
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        System.out.println("Enter size of queue:");
        size=sc.nextInt();
        q.makequeue(size);
        System.out.println("Enter 1 to enqueue or 0 to dequeue:");
        v= sc.nextInt();
        while (v==1) {
            System.out.println("Enter value:");
            input = sc.nextInt();
            q.enqueue(input);
            System.out.println("Enter 1 to enqueue or 0 to finish:");
            v= sc.nextInt();
        }
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println("Printing remaining array");
        for (int i=front;i<=back;i++){
            System.out.println(q.a[i]);
        }
    }
}

//    void search(binary_search_tree.Node root, int key){
//        java.util.Queue<binary_search_tree.Node> qobj= new LinkedList<>();
//        qobj.add(root);
//        while (!qobj.isEmpty()){
//            root=qobj.remove();
//            if(root.data==key){
//                System.out.println("Node found!");
//                break;
//            }
//            else {
//                if (hasleft(root))
//                    qobj.add((binary_search_tree.Node) leftnode(root));
//                if (hasright(root))
//                    qobj.add((binary_search_tree.Node) rightnode(root));
//            }
//        }
//        if(root.data!=key)
//            System.out.println("Node not present");
//    }

//if (root == null)
//        {
//        root = newnode;
//        }
//
//        else {
//        Node temp = root;
//        if (input < root.data) {
//        while (temp.left!=null && temp.left.data > newnode.data) {
//        temp = temp.left;
//        }
//        if(newnode.data> temp.data)
//        { temp.right=newnode;
//        System.out.println("last input: "+temp.data);}
//        else temp.left = newnode;
//        }
//        else {
//        while (temp.right!=null&&temp.right.data<newnode.data) {
//        temp = temp.right;
//        }
//        if(temp.data>newnode.data)
//        {temp.left=newnode;
//        System.out.println("last input: "+temp.data);}
//        else temp.right = newnode;
//        }
//        }