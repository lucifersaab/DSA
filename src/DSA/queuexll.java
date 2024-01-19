package DSA;

public class queuexll {

    Node back;
    Node front;

    int size;
    static class Node{
        int data;
       Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
   Node head =null;

    void enqueue(int data){
        Node n1 = new Node(data);
        size++;

        if(head==null){
            head=n1;
        }
        else {
             front = head;
            while (front.next != null) {

                front = front.next;
            }
            front.next = n1;
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

    void dequeue(){
        if (!isEmpty()) {
            size--;
            back = head;
            System.out.println("Dequeuing: " + back.data);
            head = head.next;
        }
    }

    void dequeuesecond(){
        if(!isEmpty()){
            Node temp =head;
            if(temp.next!=null){
            temp=temp.next;
            System.out.println("Second value: "+temp.data);
            head.next=temp.next;
            temp.next=null;}
            else System.out.println("Second node does not exist.");
        }
    }



    boolean isEmpty(){
        if(head==null){
            System.out.println("Queue is empty!");
            return true;
        }
        else return false;
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
    }

    public static void main(String[] args) {
        queuexll obj = new queuexll();

        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50);
        obj.display();
        System.out.println();
        obj.dequeue();
        obj.display();
        System.out.println();

        obj.reverse();
        obj.display();
        System.out.println();
        obj.dequeuesecond();
        obj.display();
    }
}
