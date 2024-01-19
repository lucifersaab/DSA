package DSA;

import java.util.Scanner;
import java.util.Stack;

public class midprac2 {

    static class Node{
        Node prev=null;
        int data;
        Node next=null;

        Node(int data)
        {
            this.data=data;
        }

    }
    static Node head=null;


    static void insert(int x){
        Node n = new Node(x);
        if (head==null)
            head=n;
        else {
            Node temp=head;

            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=n;
            n.prev=temp;
        }
    }
    static void display(){
        Node temp=head;
        int sum=0;
        int prod=1;
        int count=0;
        int average;
        int min= temp.data;
        int max=temp.data;

        while (temp!=null) {

            System.out.print(temp.data + " ");

            sum=sum+temp.data;

            prod=prod* temp.data;

            count++;

            if(min> temp.data){
                min= temp.data;
            }

            if(max<temp.data){
                max= temp.data;
            }

            temp=temp.next;
        }
        average=sum/count;
        System.out.println();
        System.out.println("Sum: "+sum);
        System.out.println("Product: "+prod);
        System.out.println("Average: "+average);
        System.out.println("Minimum: "+min);
        System.out.println("Maximum: "+max);
    }

    static void palindrome(String s){
        int x=s.length();
        boolean check=false;
        Stack<Character> stk = new Stack<>();
        for (int i=0;i<x;i++){
            stk.push(s.charAt(i));
        }
        for (int j=0;j<x;j++){
            char b=stk.pop();
            if(b == s.charAt(j)) {
                check = true;
            }
            else {
                check=false;
                break;
            }
        }
        if(check){
            System.out.println("Palindrome");
        }
        else System.out.println("Not a palindrome");
    }
    public static void main(String[] args) {
//        insert(20);
//        insert(10);
//        insert(40);
//        insert(-30);
//        insert(60);
//        insert(100);
//        display();

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter string to check palindrome: ");
        String s=sc.next();
        palindrome(s);
    }



}
