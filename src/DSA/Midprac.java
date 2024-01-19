package DSA;

import java.util.Scanner;

public class Midprac {

    static class employees{
        int id;
        String name;

        employees next=null;

        employees(int id,String name){
            this.id=id;
            this.name=name;
        }

    }
    static employees head=null;
    static Scanner sc = new Scanner(System.in);
    static void insertion(){
        System.out.println("Enter 1 to insert, 0 to cancel: ");
        int x= sc.nextInt();
        while (x==1) {
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            System.out.println("Enter name: ");
            String name = sc.next();
            employees emp = new employees(id, name);
            if(head==null){
                head=emp;
            }
            else{
                employees temp=head;
                while (temp.next!=null){
                    temp=temp.next;
                }
                temp.next=emp;
            }
            System.out.println("Enter 1 to continue, 0 to stop: ");
            x = sc.nextInt();

        }

    }

    static void display(){
        employees temp=head;
        while (temp.next!=null) {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        }
        System.out.println(temp.id+" "+ temp.name);
    }

    static void search(){
        System.out.println("Id to search: ");
        int x=sc.nextInt();
        employees temp=head;
        while (temp!=null){
            if(temp.id==x){
                break;
            }
            temp=temp.next;
        }
        if(temp!=null) {
                System.out.println(temp.id + " " + temp.name);
        }
        else System.out.println("Id not found");
    }
    static void check_duplicate(){
        employees temp=head;
        employees temp2;
        while (temp!=null){
            employees temp1=temp.next;
            temp2=temp;
            while (temp1!=null) {
                if (temp.id == temp1.id) {
                    temp2.next=temp1.next;
                    temp1.next=null;
                }
                temp1=temp1.next;
                temp2=temp2.next;
            }
            temp=temp.next;
        }



    }

    public static void main(String[] args) {
        insertion();
        display();
        search();
        System.out.println("Deleting duplicates: ");
        check_duplicate();
        display();
    }
}
