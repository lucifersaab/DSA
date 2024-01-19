package DSA;

public class Stack_Final_lab {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node Top=null;
    void push(int key){

        Node node=new Node(key);

        if (Top != null) {
            node.next = Top;
        }
        Top=node;

    }

    int pop(){
        int value=Top.data;
        Top=Top.next;
        return value;
    }

    void print(){
        Node temp=Top;
        while (temp!=null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    public static void main(String[] args) {
        Stack_Final_lab S1= new Stack_Final_lab();
        Stack_Final_lab S2= new Stack_Final_lab();
        Stack_Final_lab S3= new Stack_Final_lab();

        S1.push(10);
        S1.push(20);
        S1.push(30);
        S1.push(40);
        S1.push(50);

        System.out.println("Stack 1:");
        S1.print();

                           // S1= 50 40 30 20 10
        S2.push(60);
        S2.push(70);
        S2.push(80);
        S2.push(90);
        S2.push(100);

        System.out.println();
        System.out.println("\nStack 2:");
        S2.print();
                           // S2=100 90 80 70 60
        S3.push(S1.pop());
        S3.push(S1.pop());
        S3.push(S1.pop());
        S3.push(S1.pop());
        S3.push(S1.pop());

        S3.push(S2.pop());
        S3.push(S2.pop());
        S3.push(S2.pop());
        S3.push(S2.pop());
        S3.push(S2.pop());

        System.out.println();
        System.out.println("\nStack 3:");
        S3.print();
        System.out.println();


    }
}
