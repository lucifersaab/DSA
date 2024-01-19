package DSA;

import java.util.Scanner;

public class Midlabexam {

    //NAME: AHMED HASHIM FAROOQ
    //FA21-BCS-138

    static class Node{
        int ticketNo;
        String Customer_Name;
        Node next;


        Node(int ticketNo,String customer_Name){
            this.ticketNo=ticketNo;
            this.Customer_Name=customer_Name;
        }
    }


    static Node back=null;
    static Node front=null;

    static Scanner sc=new Scanner(System.in);

    static Node head=null;

    static void enqueue(){
        System.out.println("Enter TicketNo: ");
        int id= sc.nextInt();
        System.out.println("Enter Customer name:");
        String name=sc.next();
        Node new_node= new Node(id,name);

        if(head==null) {
            head = new_node;
            if(front==null)
                front=head;
        }
        else {
            back=head;
            while (back.next!=null){
                back=back.next;
            }
            back.next=new_node;
        }
    }

    static void display(){
        Node temp=front;
        while (temp!=null){
            System.out.print("Ticket No: "+temp.ticketNo+"  Customer Name: "+temp.Customer_Name);
            System.out.println();
            temp=temp.next;
        }
    }

    static void current_customer(){
        Node temp=front;
        System.out.println("Currently serving:");
        System.out.println("Ticket No: "+temp.ticketNo+"  Customer Name: "+temp.Customer_Name);
    }

    static void no_of_customers(){
        Node temp=front;
        int count=-1;
        System.out.println("Enter Ticket No: ");
        int y= sc.nextInt();
        while (temp!=null){
            if(temp.ticketNo==y)
                break;
            temp=temp.next;
        }

        while (temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("Number of Customers ahead: "+count);
    }

    static void search(){
        System.out.println("Enter TicketNo to search: ");
        int x=sc.nextInt();
        Node temp=front;

        while (temp!=null){
            if(temp.ticketNo==x){
                System.out.println("Ticket No: "+temp.ticketNo+" Customer Name: "+temp.Customer_Name);
            }
            temp=temp.next;
        }

    }

    public static void main(String[] args) {
        int y;
        System.out.println("LINEAR QUEUE MANAGEMENT SYSTEM");
        System.out.println("*******************************");
        do {
            System.out.println();
            System.out.println("1. Add a customer");
            System.out.println("2. See the customer details");
            System.out.println("3. Customer currently serving");
            System.out.println("4. No. of customers ahead");
            System.out.println("5. Display all customers");
            System.out.println("6. Exit");
            System.out.println("Enter your option [1-6]");
            y = sc.nextInt();

            switch (y) {
                case 1 -> enqueue();
                case 2 -> search();
                case 3 -> current_customer();
                case 4 -> no_of_customers();
                case 5 -> display();
                case 6 -> System.out.println("--Exiting--");
            }
        }while (y!=6);
    }

}
