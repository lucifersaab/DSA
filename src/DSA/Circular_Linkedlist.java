package DSA;

import java.util.Scanner;

public class Circular_Linkedlist {

    static Scanner sc = new Scanner(System.in);
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head =null;

    void creation(){
        System.out.println("Enter value: ");
        int s= sc.nextInt();
        Node n = new Node(s);
        if(head==null){
            head=n;
        }
        else {
            Node temp = head;
            while (temp.next != head){
                temp = temp.next;
            }
            temp.next=n;
        }
        n.next=head;

    }
    void display(){
        Node temp=head;

        while (temp.next!=head){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(temp.data);

    }
    void size(){
        int counter=1;
        Node temp=head;
        while(temp.next!=head){
            counter++;
            temp=temp.next;
        }
        System.out.println("Size: "+counter);
    }

    void delete (){
        System.out.println("Enter position:");
        int x = sc.nextInt();
        Node temp1 = head;
        Node temp2 = head;
        for (int i = 0; i < x-2 ; i++) {
            temp1 = temp1.next;
        }
        for (int i = 0; i < x - 1; i++) {
            temp2 = temp2.next;
        }
        temp1.next=temp2.next;
    }

    public static void main(String[] args) {
        Circular_Linkedlist cl = new Circular_Linkedlist();
        int n;
        do{
            cl.creation();
            System.out.println("Do u want to continue? 1 for yes, 0 for no");
             n= sc.nextInt();
        }while (n==1);

        cl.display();
        cl.size();
        cl.delete();
        cl.display();
    }

}
