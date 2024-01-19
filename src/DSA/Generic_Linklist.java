package DSA;

import java.util.Comparator;
import java.util.Scanner;

public class Generic_Linklist<T>  {

        Scanner sc = new Scanner(System.in);


    static class Node<T>{
            T data;
            Node next;

            Node(T data){
                this.data=data;
                this.next=null;
            }
        }
        Node head =null;


        void creation(){
            int n,z,x;
            T data;

            do {
                System.out.println("Enter 1 to insert node at start, Enter 2 to insert data at the end, Enter 3 to insert data at the a specified position: ");
                z=sc.nextInt();

                System.out.println("Enter data for new node:");
                data = (T) sc.next();

                Node node1 = new Node(data);

                if (head == null) {
                    head = node1;
                }

                else {
                    switch (z) {
                        case 1 -> {
                            node1.next = head;
                            head = node1;
                        }
                        case 2 -> {
                            Node temp = head;
                            while (temp.next != null) {

                                temp = temp.next;
                            }
                            temp.next = node1;
                        }
                        case 3 -> {
                            System.out.println("Enter position:");
                            x = sc.nextInt();
                             Node temp1 = head;
                            for (int i = 0; i < x - 2; i++) {
                                temp1 = temp1.next;
                            }
                            node1.next = temp1.next;
                            temp1.next = node1;
                        }
                    }
                }
                System.out.println("Do you want to add more nodes? Enter 1 for yes/ 0 for no: ");
                n = sc.nextInt();
            }while (n==1);

        }

        void delete(){
            System.out.println("Enter 1 to delete from start");
            System.out.println("Enter 2 to delete from a specific location");
            System.out.println("Enter 3 to delete from end");
            int x= sc.nextInt();
            switch (x) {
                case 1 -> {
                    Node temp;
                    temp = head;
                    head = temp.next;
                }
                case 2 -> {
                    System.out.println("Enter position:");
                    x = sc.nextInt();
                    Node temp1 = head;
                    Node temp2 = head;
                    for (int i = 1; i < x - 3; i++) {
                        temp2 = temp2.next;
                    }
                    for (int i = 1; i < x - 2; i++) {
                        temp1 = temp1.next;
                    }
                    temp2.next=temp1;


                }
                case 3 -> {
                    Node temp3=head;
                    Node temp4=head;
                    temp3=temp3.next;
                    while (temp3.next!=null){
                        temp3=temp3.next;
                        temp4=temp4.next;
                    }
                    temp4.next=null;

                }
            }
        }

        void search(){
            System.out.println("Data to search:");
            T s = (T) sc.next();
            Node temp=head;
            int p=1;
            while (temp!=null)
            {
                System.out.println("checking: "+s);
                System.out.println("value is:" +temp.data);
                if(s==(T)temp.data){
                    System.out.println("Data found in link list at position: " +p);
                    break;
                }
                else
                {
                    System.out.println("Not found");
                }

                temp=temp.next;
                p++;
            }

        }

        void display(){
            if(head==null)
                System.out.println("Link list does not exist.");
            else{
                 Node temp = head;

                while (temp!=null)
                {
                    System.out.print(temp.data+" ");

                    temp=temp.next;
                }

            }
        }

        public static void main(String[] args) {
            Generic_Linklist l = new Generic_Linklist();
            int d;
            Scanner sc = new Scanner(System.in);
            System.out.println("Do u want to perform an action?");
            System.out.println("Enter 1 for yes");
            System.out.println("Enter 0 for no");
            d=sc.nextInt();
            while (d==1) {
                System.out.println("Enter 1 for adding node");
                System.out.println("Enter 2 for deleting node");
                System.out.println("Enter 3 for displaying linkedlist");
                System.out.println("Enter 4 for searching linkedlist");
                int x= sc.nextInt();
                switch (x){
                    case 1 -> {
                        l.creation();

                    }
                    case 2 ->
                    {
                        l.delete();
                    }
                    case 3 ->{
                        l.display();

                    }
                    case 4 ->{
                        l.search();
                    }

                }

                System.out.println();
                System.out.println("Do u want to perform an action?");
                System.out.println("Enter 1 for yes");
                System.out.println("Enter 0 for no");
                d=sc.nextInt();
            }
        }

}
