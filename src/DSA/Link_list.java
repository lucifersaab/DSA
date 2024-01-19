package DSA;

import java.util.Random;
import java.util.Scanner;

public class Link_list {
    Scanner sc = new Scanner(System.in);

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
        int n,z,x;
        int data;

        do {
            System.out.println("Enter 1 to insert node at start, Enter 2 to insert data at the end, Enter 3 to insert data at the a specified position: ");
            z=sc.nextInt();

            System.out.println("Enter data for new node:");
            data = sc.nextInt();

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
        int s = sc.nextInt();
        Node temp=head;
        int p=1;
        while (temp!=null)
        {
            System.out.println("checking: "+s);
            System.out.println("value is:" +temp.data);
            if(temp.data==s){
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
    Node head1;


    Node temp;
    Node temp2;
    void copy(Node list){
          temp = list;
         temp2=list;
        if(head1==null){
            head1=temp2;
        }
        while (temp!=null){
            temp2.data=temp.data;
            temp2 = temp2.next;
            temp=temp.next;

        }

        print_copy_list(head1);
    }

    void print_copy_list(Node h){
        Node t=h;
        System.out.println("COPIED LIST:");
        while (t!= null){
            System.out.print(t.data+" ");
            t=t.next;
        }
    }
    void reverse(){
        Node temp1, temp2, temp3;
        temp1 = head;
        temp2 = temp1.next;
        temp3 = temp1.next;
        int i=0;

        while (temp3!=null) {
            if(i==0){
                temp1.next=null;
                i++;
            }
            temp3=temp3.next;
            temp2.next = temp1;
            temp1=temp2;
            temp2 = temp3;
        }
        head=temp1;
        display();
    }

    public void concat(Node list1, Node list2){
        Link_list l3 = new Link_list();
        Node temp = list1;
        Node temp2 = list2;



            while (temp!=null) {
                Node node = new Node(temp.data);
                if(l3.head==null){
                    l3.head=node;
                }
                else {
                    Node temp3= l3.head;
                    while (temp3.next!=null){temp3=temp3.next;}
                    temp3.next = node;

                }
                temp = temp.next;

            }

            while (temp2!=null){
                Node node = new Node(temp2.data);
                Node temp3=l3.head;
                while (temp3.next!=null){temp3=temp3.next;}

                temp3.next=node;
                temp2=temp2.next;

            }
        copy(l3.head);

    }

    void replace (Node list, int I, int x){
        Node temp1 = list;
        for (int i = 0; i < I - 1; i++) {
            temp1 = temp1.next;
        }
        temp1.data=x;
    }
    void rotate(int d ){
        Node temp = head;
        Node temp2 = head; //head
        Node temp3 = head; //end

        while (temp3.next!=null){
            temp3=temp3.next;
        }

        for(int i=0;i<d-1;i++){
            if(temp.next!=null)
                temp=temp.next;
        }

        head=temp.next;
        temp.next=null;
        temp3.next=temp2;

    }
    int size(){
        int counter=0;
        Node temp=head;
        while (temp!=null){

            counter++;
            temp=temp.next;

        }
        return counter;
    }

    void shuffle(){
        Random rand = new Random();
        int loop = rand.nextInt(10,15);

        Node temp=head;
        for(int i=0;i<loop;i++){
            int num= rand.nextInt(2,size());
            System.out.println("num: "+num);
            rotate(num);
            for(int j=0;j<num;j++){
                if (temp.next!=null)
                    temp=temp.next;
            }
            replace(head,num,head.data);
            head.data=temp.data;
            display();

        }


    }

    void question(Node root){
        Node p=head;
        Node q=p.next;
        p.next=q.next;
        q.next=q.next.next;
        p.next.next=q;
    }

    public static void main(String[] args) {
        Link_list l = new Link_list();
        Link_list l2 = new Link_list();
        int d;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do u want to perform an action?");
        System.out.println("Enter 1 for yes");
        System.out.println("Enter 0 for no");
        d=sc.nextInt();
        while (d==1) {
            System.out.println("Enter 1 for adding node");
            System.out.println("Enter 2 for deleting node");
            System.out.println("Enter 3 for displaying linked list");
            System.out.println("Enter 4 for searching linked list");
            System.out.println("Enter 5 for copying first linked list");
            System.out.println("Enter 6 for printing copied linked list");
            System.out.println("Enter 7 for reversing linked list");
            System.out.println("Enter 8 for second linked list");
            System.out.println("Enter 9 for concatenating the two lists");
            System.out.println("Enter 10 for replacing data in linked list");
            System.out.println("Enter 11 for rotating linked list");
            System.out.println("Enter 12 for shuffling linked list");
            System.out.println("Enter 13 for size of linked list");
            System.out.println("Enter 14 for answer to question");
            int x= sc.nextInt();
            switch (x){
                case 1 ->
                    l.creation();

                case 2 ->
                    l.delete();

                case 3 ->
                    l.display();

                case 4 ->
                    l.search();

                case 5 ->
                    l.copy(l.head);

                case 6->
                    l.print_copy_list(l.head1);

                case 7->
                    l.reverse();

                case 8->
                    l2.creation();

                case 9->
                    l.concat(l.head,l2.head);

                case 10->
                {
                    System.out.println("Enter location:");
                    int z = sc.nextInt();
                    System.out.println("Enter number to replace:");
                    int ip= sc.nextInt();
                    l.replace(l.head,z,ip);
                }
                case 11-> {
                    System.out.println("Enter position to rotate:");
                    int y = sc.nextInt();
                    l.rotate(y);
                }
                case 12->
                    l.shuffle();
                case 13-> System.out.println(l.size());
                case 14-> l.question(l.head);

            }


            System.out.println();
            System.out.println("Do u want to perform an action?");
            System.out.println("Enter 1 for yes");
            System.out.println("Enter 0 for no");
            d=sc.nextInt();

        }
    }
}
