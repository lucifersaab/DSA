package DSA;

public class stackxll {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
     Node head1 =null;

    void push(int data){
        Node n1 = new Node(data);
        if (head1 != null) {
            n1.next = head1;
        }
        head1 = n1;
    }

    void pop(){
        Node top = head1;

        if(top!=null) {
            System.out.println("poped: " + top.data);
            head1 = head1.next;
        }
        else {
            System.out.println("Stack is empty.");
        }

    }

    void display(){
        Node ptr = head1;

        while (ptr!=null){
            System.out.println(ptr.data+" ");
            ptr=ptr.next;
        }
    }

    public static void main(String[] args) {
        Link_list l = new Link_list();

        stackxll obj = new stackxll();

        obj.push(100);
        obj.push(200);
        obj.push(300);
        obj.push(400);

        obj.pop();
        obj.pop();
        obj.pop();

        obj.display();

    }
}
