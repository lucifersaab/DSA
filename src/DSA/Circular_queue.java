package DSA;

import java.util.Scanner;


public class Circular_queue {
    static Queue q = new Queue();
    static int n,v,input;
    static int a[];

    static int front=-1;
    static int back=-1;
    static int counter=0;

    static Scanner sc = new Scanner(System.in);

    static Circular_queue cq= new Circular_queue();

    public static void main(String[] args) {
        cq.make_cq();
        cq.disp();

    }

    public void make_cq() {
        System.out.println("Enter size of queue:");
        n = sc.nextInt();
        a=new int[n];
        int z;
        do {
            System.out.println("Enter 1 to enqueue or 0 to dequeue:");
            v = sc.nextInt();

            switch (v) {
                case 1:

                    System.out.println("Enter value:");
                    input = sc.nextInt();
                    cq.c_enqueue(a, input);
                    break;

                case 0:

                    System.out.println(cq.c_dequeue());
                    break;

            }

            System.out.println("Do u want to continue? Enter 1 for yes, 0 for no:");
            z = sc.nextInt();
        }while (z==1);
    }


    public void c_enqueue(int[] a, int e ){
        if(isfull()){
            System.out.println("Queue is full.");
        }
        else {
            back=(back+1)%n;
            System.out.println("added at index: "+back);
            a[back]=e;
            if(front==-1){
                front=0;
            }
        }
    }

    public int c_dequeue(){
        int e=0;
        if(isempty()){
            System.out.println("Queue is empty.");
        }
        else {
            System.out.println("dequeued from: "+front);
            e=a[front];
            front=(front+1)%n;
            if(front==back){
                front=back=-1;
            }
        }
        return e;
    }

    public boolean isfull(){
        boolean x=false;
        if((back+1)%n== front) {
            x= true;
        }
        return x;
    }
     public boolean isempty(){
        if(back==-1){
            return true;
        }
        else return false;
    }
    public void disp(){
        int b=0;
        int i;
        System.out.println("Front is: "+front);
        System.out.println("Back is: "+back);
        for( i=front;i!=back;i=(i+1)%n){
            System.out.println(a[i]);
        }
        System.out.println(a[i+1]);
    }

    public void size(){
        
        for(int i=front;i!=(back+1)%n;i++) {
            counter++;
            if (i==n-1){
                i=0;
            }
        }
            System.out.println(counter);
    }

}



