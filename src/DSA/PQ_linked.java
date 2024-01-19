package DSA;

import java.util.Scanner;

public class PQ_linked {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    Node front=null;
    Node back=null;

    Node head=null;
    static Scanner sc = new Scanner(System.in);

    void insertion(){
        System.out.println("Enter val:");
        int n=sc.nextInt();
        while (n!=-1) {
            Node new_node = new Node(n);

            if (head == null) {
                head = new_node;
                front = head;
            }
            else {
                back=head;
                while (back.next!=null)
                {
                    back=back.next;
                }
                back.next=new_node;
            }

            System.out.println("Enter val:");
            n=sc.nextInt();
        }
    }

    void display(){
        front=head;
        while (front!=null){
            System.out.print(front.data+" ");
            front=front.next;
        }

    }

    Node find_min(Node head){
        front=head;
        Node min = front;
        while (front!=null){
            if(min.data>front.data)
                min=front;
            front=front.next;
        }
        return min;
    }

    void dequeue(){

        Node min = find_min(head);
        front=head;
        while (front.next!=min){
            front=front.next;
        }
        front.next=min.next;

    }

    public static void main(String[] args) {
        PQ_linked obj = new PQ_linked();
        obj.insertion();
        obj.display();
        obj.dequeue();
        System.out.println();
        obj.display();
        obj.dequeue();
        System.out.println();
        obj.display();
        obj.dequeue();
        System.out.println();
        obj.display();
        obj.dequeue();
        System.out.println();
        obj.display();
    }
}
